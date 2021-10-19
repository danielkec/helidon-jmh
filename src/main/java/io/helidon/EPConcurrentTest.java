package io.helidon;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.helidon.common.reactive.EmittingPublisherReentrant;
import io.helidon.common.reactive.EmittingPublisherSynchronized;
import io.helidon.common.reactive.Multi;
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

    EmittingPublisherSynchronized<String> sync;
    EmittingPublisherReentrant<String> reentrant;
    Stream<String> parallelDataStream;

    @Setup(Level.Invocation)
    public void setUp() {
        sync = EmittingPublisherSynchronized.create();
        reentrant = EmittingPublisherReentrant.create();
        parallelDataStream = TEST_DATA.parallelStream();
    }

    static final List<String> TEST_DATA = IntStream.range(0, 1_000_000)
            .mapToObj(i -> String.format("%d%d%d%d%d", i, i, i, i, i))
            .collect(Collectors.toList());

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
}
