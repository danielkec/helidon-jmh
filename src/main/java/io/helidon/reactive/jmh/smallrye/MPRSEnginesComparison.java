package io.helidon.reactive.jmh.smallrye;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;
import org.eclipse.microprofile.reactive.streams.operators.spi.ReactiveStreamsEngine;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

abstract class MPRSEnginesComparison<T> {


    public static void main(String[] args) throws Exception {
        System.setProperty("helidon.common.reactive.strict.mode", Boolean.TRUE.toString());
        Options opt = new OptionsBuilder()
                .include(HelidonRS.class.getSimpleName())
                .include(SmallRyeRS.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    static final List<Integer> TEST_DATA = IntStream.range(0, 1_000_000)
            .boxed()
            .collect(Collectors.toList());

    @Benchmark
    public void map() {
        run(rs().map(Function.identity()));
    }

    @Benchmark
    public void peek() {
        run(rs().peek(s -> {
        }));
    }

    @Benchmark
    public void filter() {
        run(rs().filter(s -> true));
    }

    @Benchmark
    public void skip() {
        run(rs().skip(5));
    }

    @Benchmark
    public void takeWhile() {
        run(rs().takeWhile(s -> true));
    }

    @Benchmark
    public void dropWhile() {
        run(rs().dropWhile(s -> false));
    }

    @Benchmark
    public void limit() {
        run(rs().limit(Integer.MAX_VALUE));
    }

    @Benchmark
    public void flatMap() {
        run(rs().flatMap(ReactiveStreams::of));
    }

    @Benchmark
    public void flatMapIterable() {
        run(rs().flatMapIterable(List::of));
    }

    @Benchmark
    public void toList() {
        rs().toList().run(engine());
    }

    private void run(PublisherBuilder<T> builder) {
        builder.forEach(s -> {
        }).run(engine());
    }

    abstract ReactiveStreamsEngine engine();

    abstract List<T> data();

    PublisherBuilder<T> rs() {
        return ReactiveStreams.fromIterable(data());
    }
}
