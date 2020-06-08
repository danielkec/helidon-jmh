package io.helidon;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.helidon.common.reactive.BufferedEmittingPublisherTTAS;
import io.helidon.common.reactive.BufferedEmittingPublisherReentrant;
import io.helidon.common.reactive.BufferedEmittingPublisherSynchronized;
import io.helidon.common.reactive.Multi;
import io.helidon.common.reactive.OriginThreadPublisher;
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
    public void testEmitterTTASUnbounded(Blackhole bh) {
        BufferedEmittingPublisherTTAS<String> emitter = BufferedEmittingPublisherTTAS.create();
        Multi.from(emitter).forEach(bh::consume);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterTTASReqMillion(Blackhole bh) {
        BufferedEmittingPublisherTTAS<String> emitter = BufferedEmittingPublisherTTAS.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.from(emitter).subscribe(subscriber);
        subscriber.request(1_000_000);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterTTASReqOneByOne(Blackhole bh) {
        BufferedEmittingPublisherTTAS<String> emitter = BufferedEmittingPublisherTTAS.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.from(emitter).subscribe(subscriber);
        for (String TEST_DATUM : TEST_DATA) {
            subscriber.request(1);
            emitter.emit(TEST_DATUM);
        }
    }


    @Benchmark
    public void testEmitterSyncUnbounded(Blackhole bh) {
        BufferedEmittingPublisherSynchronized<String> emitter = BufferedEmittingPublisherSynchronized.create();
        Multi.from(emitter).forEach(bh::consume);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterSyncReqMillion(Blackhole bh) {
        BufferedEmittingPublisherSynchronized<String> emitter = BufferedEmittingPublisherSynchronized.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.from(emitter).subscribe(subscriber);
        subscriber.request(1_000_000);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterSyncReqOneByOne(Blackhole bh) {
        BufferedEmittingPublisherSynchronized<String> emitter = BufferedEmittingPublisherSynchronized.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.from(emitter).subscribe(subscriber);
        for (String TEST_DATUM : TEST_DATA) {
            subscriber.request(1);
            emitter.emit(TEST_DATUM);
        }
    }


    @Benchmark
    public void testEmitterReentrantUnbounded(Blackhole bh) {
        BufferedEmittingPublisherReentrant<String> emitter = BufferedEmittingPublisherReentrant.create();
        Multi.from(emitter).forEach(bh::consume);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterReentrantReqMillion(Blackhole bh) {
        BufferedEmittingPublisherReentrant<String> emitter = BufferedEmittingPublisherReentrant.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.from(emitter).subscribe(subscriber);
        subscriber.request(1_000_000);
        TEST_DATA.forEach(emitter::emit);
    }

    @Benchmark
    public void testEmitterReentrantReqOneByOne(Blackhole bh) {
        BufferedEmittingPublisherReentrant<String> emitter = BufferedEmittingPublisherReentrant.create();
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.from(emitter).subscribe(subscriber);
        for (String TEST_DATUM : TEST_DATA) {
            subscriber.request(1);
            emitter.emit(TEST_DATUM);
        }
    }


    @Benchmark
    public void testOTPUnbounded(Blackhole bh) {
        OriginThreadPublisher<String, String> emitter = new OriginThreadPublisher<>() {
        };
        Multi.from(emitter).forEach(bh::consume);
        TEST_DATA.forEach(emitter::submit);
    }

    @Benchmark
    public void testOTPReqMillion(Blackhole bh) {
        OriginThreadPublisher<String, String> emitter = new OriginThreadPublisher<>() {
        };
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.from(emitter).subscribe(subscriber);
        subscriber.request(1_000_000);
        TEST_DATA.forEach(emitter::submit);
    }

    @Benchmark
    public void testOTPReqOneByOne(Blackhole bh) {
        OriginThreadPublisher<String, String> emitter = new OriginThreadPublisher<>() {
        };
        TestSubscriber<String> subscriber = new TestSubscriber<>(bh);
        Multi.from(emitter).subscribe(subscriber);
        TEST_DATA.forEach(data -> {
            subscriber.request(1);
            emitter.submit(data);
        });
    }
}
