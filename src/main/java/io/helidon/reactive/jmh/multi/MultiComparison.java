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
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public abstract class MultiComparison {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
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

    private void run(Multi<Integer> multi, Blackhole bh) {
        multi.forEach(bh::consume);
    }

    @Benchmark
    public void map(Blackhole bh) {
        run(multi().map(i -> i), bh);
    }

    @Benchmark
    public void peek(Blackhole bh) {
        run(multi().peek(i -> {
        }), bh);
    }

    @Benchmark
    public void distinct(Blackhole bh) {
        run(multi().distinct(), bh);
    }

    @Benchmark
    public void filter(Blackhole bh) {
        run(multi().filter(i -> true), bh);
    }

    @Benchmark
    public void takeWhile(Blackhole bh) {
        run(multi().takeWhile(i -> true), bh);
    }

    @Benchmark
    public void dropWhile(Blackhole bh) {
        run(multi().dropWhile(i -> false), bh);
    }

    @Benchmark
    public void limit(Blackhole bh) {
        run(multi().limit(Integer.MAX_VALUE), bh);
    }

    @Benchmark
    public void skip(Blackhole bh) {
        run(multi().skip(5), bh);
    }

    @Benchmark
    public void flatMap(Blackhole bh) {
        run(multi().flatMap(Multi::just), bh);
    }

    @Benchmark
    public void flatMapIterable(Blackhole bh) {
        run(multi().flatMapIterable(List::of), bh);
    }

    @Benchmark
    public void collectList(Blackhole bh) throws InterruptedException, ExecutionException, TimeoutException {
        multi().collectList().get(1, TimeUnit.SECONDS);
    }
}
