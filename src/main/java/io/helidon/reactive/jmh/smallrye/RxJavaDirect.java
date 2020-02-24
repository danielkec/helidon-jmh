package io.helidon.reactive.jmh.smallrye;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RxJavaDirect {


    public static void main(String[] args) throws Exception {
        System.setProperty("helidon.common.reactive.strict.mode", Boolean.TRUE.toString());
        Options opt = new OptionsBuilder()
                .include(RxJavaDirect.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    static final List<Integer> TEST_DATA = IntStream.range(0, 2_000_000)
            .boxed()
            .collect(Collectors.toList());

    @Benchmark
    public void map() {
        run(rs().map(v -> v));
    }

    @Benchmark
    public void peek() {
        run(rs().doOnNext(s -> {
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
        run(rs().skipWhile(s -> false));
    }

    @Benchmark
    public void limit() {
        run(rs().take(Integer.MAX_VALUE));
    }

    @Benchmark
    public void flatMap() {
        run(rs().flatMap(Flowable::just));
    }

    @Benchmark
    public void flatMapLoadOnPassedInPublisher() {
        run(Flowable.just(1).flatMap(i -> rs()));
    }

    @Benchmark
    public void flatMapIterable() {
        run(rs().flatMapIterable(List::of));
    }

    @Benchmark
    public void toList() {
        run(rs().toList());
    }

    private void run(Flowable<?> builder) {
        builder.subscribe();
    }

    private void run(Single<?> builder) {
        builder.subscribe();
    }

    Flowable<Integer> rs() {
        return Flowable.fromIterable(TEST_DATA);
    }
}
