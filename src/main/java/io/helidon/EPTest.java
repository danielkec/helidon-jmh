package io.helidon;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.helidon.common.reactive.EmittingPublisherReentrant;
import io.helidon.common.reactive.EmittingPublisherSynchronized;
import io.helidon.common.reactive.Multi;
import io.helidon.common.reactive.TestSubscriber;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class EPTest {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(EPTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    static final List<String> TEST_DATA = IntStream.range(0, 1_000_000)
            .mapToObj(i -> String.format("%d%d%d%d%d", i, i, i, i, i))
            .collect(Collectors.toList());


    @Benchmark
    public void testEmitterSyncUnbounded(Blackhole bh) {
        EmittingPublisherSynchronized<String> emitter = EmittingPublisherSynchronized.create();
        Multi.from(emitter).forEach(bh::consume);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterSyncReqMillion(Blackhole bh) {
        EmittingPublisherSynchronized<String> emitter = EmittingPublisherSynchronized.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(emitter).subscribe(subscriber);
        subscriber.request(1_000_000);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterSyncReqOneByOne(Blackhole bh) {
        EmittingPublisherSynchronized<String> emitter = EmittingPublisherSynchronized.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(emitter).subscribe(subscriber);
        for (String TEST_DATUM : TEST_DATA) {
            subscriber.request(1);
            emitter.emit(TEST_DATUM);
        }
    }


    @Benchmark
    public void testEmitterReentrantUnbounded(Blackhole bh) {
        EmittingPublisherReentrant<String> emitter = EmittingPublisherReentrant.create();
        Multi.create(emitter).forEach(bh::consume);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterReentrantReqMillion(Blackhole bh) {
        EmittingPublisherReentrant<String> emitter = EmittingPublisherReentrant.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(emitter).subscribe(subscriber);
        subscriber.request(1_000_000);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterReentrantReqOneByOne(Blackhole bh) {
        EmittingPublisherReentrant<String> emitter = EmittingPublisherReentrant.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.create(emitter).subscribe(subscriber);
        for (String TEST_DATUM : TEST_DATA) {
            subscriber.request(1);
            emitter.emit(TEST_DATUM);
        }
    }
}
