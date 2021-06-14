package io.helidon.reactive.jmh.webserver;

import java.io.InputStream;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.helidon.common.http.DataChunk;
import io.helidon.common.reactive.IoMulti;
import io.helidon.common.reactive.Multi;
import io.helidon.reactive.jmh.Histogram;
import io.helidon.webclient.WebClient;
import io.helidon.webclient.WebClientResponse;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
public abstract class BackPressureComparison {


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(OneByOne1M100x.class.getSimpleName())
                .include(Unbounded1M100x.class.getSimpleName())
                .include(OneByOne1k100x.class.getSimpleName())
                .include(Unbounded1k100x.class.getSimpleName())
                .include(OneByOne1k10000x.class.getSimpleName())
                .include(Unbounded1k10000x.class.getSimpleName())
                .forks(1)
                .build();

        Collection<RunResult> results = new Runner(opt).run();
        Histogram histogram = Histogram.create();
        results.forEach(runResult -> {
            String[] fqdn = runResult.getParams().getBenchmark().split("\\.");
            var label = String.format("%s.%s", fqdn[fqdn.length - 2], fqdn[fqdn.length - 1]);
            histogram.add(label, runResult.getAggregatedResult().getPrimaryResult().getScore());
        });

        System.out.println();
        System.out.println(histogram.render());
    }

    abstract int bufferSize();

    abstract long streamSize();

    abstract long requestByN();

    private WebServer webServer;
    private WebClient webClient;

    @Setup(Level.Iteration)
    public void setUp() {
        System.setProperty("back.pressure.prefetch", String.valueOf(requestByN()));
        webServer = WebServer.builder()
                .routing(Routing.builder()
                        .get("/", (req, res) -> res.send(pub(bufferSize())
                                .limit(streamSize())))
                        .build())
                .build()
                .start()
                .await(30, TimeUnit.SECONDS);

        webClient = WebClient.builder()
                .baseUri("http://localhost:" + webServer.port())
                .build();
    }

    @TearDown(Level.Iteration)
    public void tearDown() {
        webServer.shutdown().await(30, TimeUnit.SECONDS);
    }

    static Multi<DataChunk> pub(int bufferSize) {
        return IoMulti.multiFromStreamBuilder(randomEndlessIs())
                .byteBufferSize(bufferSize)
                .build()
                .map(byteBuffer -> DataChunk.create(true, byteBuffer));
    }

    static InputStream randomEndlessIs() {
        Random random = new Random();
        return new InputStream() {
            @Override
            public synchronized int read() {
                return random.nextInt(Byte.MAX_VALUE);
            }
        };
    }

    @Benchmark
    public void test(Blackhole bh) {
        webClient.get()
                .path("/")
                .request()
                .peek(res -> {
                    assert res.status().code() == 200;
                })
                .flatMap(WebClientResponse::content)
                .forEach(chunk -> {
                    bh.consume(chunk.bytes());
                    chunk.release();
                })
                .await(30, TimeUnit.SECONDS);
    }
}
