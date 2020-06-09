package io.helidon;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.helidon.common.reactive.BufferedEmittingPublisherReentrant;
import io.helidon.common.reactive.BufferedEmittingPublisherSynchronized;
import io.helidon.common.reactive.BufferedEmittingPublisherTTAS;
import io.helidon.common.reactive.Multi;
import io.helidon.common.reactive.OriginThreadPublisher;
import io.helidon.common.reactive.TestSubscriber;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
public class EPConcurrentTest {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(EPConcurrentTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    BufferedEmittingPublisherTTAS<String> ttas;
    BufferedEmittingPublisherSynchronized<String> sync;
    BufferedEmittingPublisherReentrant<String> reentrant;
    OriginThreadPublisher<String, String> otp;
    Stream<String> parallelDataStream;

    @Setup(Level.Invocation)
    public void setUp() {
        ttas = BufferedEmittingPublisherTTAS.create();
        sync = BufferedEmittingPublisherSynchronized.create();
        reentrant = BufferedEmittingPublisherReentrant.create();
        otp = new OriginThreadPublisher<>() {};
        parallelDataStream = TEST_DATA.parallelStream();
    }

    static final List<String> TEST_DATA = IntStream.range(0, 1_000_000)
            .mapToObj(i -> String.format("%d%d%d%d%d", i, i, i, i, i))
            .collect(Collectors.toList());

    @Benchmark
    public void testEmitterTTASUnbounded(Blackhole bh) {
        Multi.create(ttas).forEach(bh::consume);
        parallelDataStream.forEach(ttas::emit);
    }

    @Benchmark
    public void testEmitterTTASReqMillion(Blackhole bh) {
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(ttas).subscribe(subscriber);
        subscriber.request(1_000_000);
        parallelDataStream.forEach(ttas::emit);
    }

    @Benchmark
    public void testEmitterTTASReqOneByOne(Blackhole bh) {
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(ttas).subscribe(subscriber);
        parallelDataStream.forEach(s -> {
            subscriber.request(1);
            ttas.emit(s);
        });
    }


    @Benchmark
    public void testEmitterSyncUnbounded(Blackhole bh) {
        Multi.create(sync).forEach(bh::consume);
        parallelDataStream.forEach(sync::emit);
    }

    @Benchmark
    public void testEmitterSyncReqMillion(Blackhole bh) {
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(sync).subscribe(subscriber);
        subscriber.request(1_000_000);
        parallelDataStream.forEach(sync::emit);
    }

    @Benchmark
    public void testEmitterSyncReqOneByOne(Blackhole bh) {
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(sync).subscribe(subscriber);
        parallelDataStream.forEach(s -> {
            subscriber.request(1);
            sync.emit(s);
        });
    }


    @Benchmark
    public void testEmitterReentrantUnbounded(Blackhole bh) {
        Multi.create(reentrant).forEach(bh::consume);
        parallelDataStream.forEach(reentrant::emit);
    }

    @Benchmark
    public void testEmitterReentrantReqMillion(Blackhole bh) {
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(reentrant).subscribe(subscriber);
        subscriber.request(1_000_000);
        parallelDataStream.forEach(reentrant::emit);
    }

    @Benchmark
    public void testEmitterReentrantReqOneByOne(Blackhole bh) {
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(reentrant).subscribe(subscriber);
        parallelDataStream.forEach(s -> {
            subscriber.request(1);
            reentrant.emit(s);
        });
    }


    @Benchmark
    public void testOTPUnbounded(Blackhole bh) {
        Multi.create(otp).forEach(bh::consume);
        parallelDataStream.forEach(otp::submit);
    }

    @Benchmark
    public void testOTPReqMillion(Blackhole bh) {
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(otp).subscribe(subscriber);
        subscriber.request(1_000_000);
        parallelDataStream.forEach(otp::submit);
    }

    @Benchmark
    public void testOTPReqOneByOne(Blackhole bh) {
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(otp).subscribe(subscriber);
        parallelDataStream.forEach(s -> {
            subscriber.request(1);
            otp.submit(s);
        });
    }
}
