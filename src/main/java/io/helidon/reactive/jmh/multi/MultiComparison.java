package io.helidon.reactive.jmh.multi;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.helidon.common.reactive.Multi;
import io.helidon.reactive.jmh.Histogram;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public abstract class MultiComparison {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(OldMulti.class.getSimpleName())
                .include(NewMulti.class.getSimpleName())
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

    static final List<Integer> TEST_DATA = IntStream.range(0, 2_000_000)
            .boxed()
            .collect(Collectors.toList());

    abstract Multi<Integer> multi();

    private void run(Multi<Integer> multi) {
        multi.forEach(integer -> {
        });
    }

    @Benchmark
    public void map() {
        run(multi().map(i -> i));
    }

    @Benchmark
    public void peek() {
        run(multi().peek(i -> {
        }));
    }

    @Benchmark
    public void distinct() {
        run(multi().distinct());
    }

    @Benchmark
    public void filter() {
        run(multi().filter(i -> true));
    }

    @Benchmark
    public void takeWhile() {
        run(multi().takeWhile(i -> true));
    }

    @Benchmark
    public void dropWhile() {
        run(multi().dropWhile(i -> false));
    }

    @Benchmark
    public void limit() {
        run(multi().limit(Integer.MAX_VALUE));
    }

    @Benchmark
    public void skip() {
        run(multi().skip(5));
    }

    @Benchmark
    public void flatMap() {
        run(multi().flatMap(Multi::just));
    }

    @Benchmark
    public void flatMapIterable() {
        run(multi().flatMapIterable(List::of));
    }

    @Benchmark
    public void collectList() throws InterruptedException, ExecutionException, TimeoutException {
        multi().collectList().get(10, TimeUnit.SECONDS);
    }
}
