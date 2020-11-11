package io.helidon.reactive.jmh.multi;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;
import java.util.concurrent.Flow;

import io.helidon.common.reactive.Multi;

public class ConcatArrayComparison {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ConcatArrayComparison.class.getSimpleName())
                .warmupIterations(5)
                .forks(2)
                .build();

        Collection<RunResult> results = new Runner(opt).run();
    }

    @SuppressWarnings("unchecked")
    private static Flow.Publisher<Integer>[] createPubs() {
        return new Flow.Publisher[] {
                Multi.just(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3),
                Multi.just(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3),
                Multi.just(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3),
                Multi.just(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3),
                Multi.just(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3),
                Multi.just(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3)};
    }

    @Benchmark
    public void variableRequestsOldCA(Blackhole bh) {
        new MultiConcatArrayOld<Integer>(createPubs())
                .subscribe(new TestSubscriber(bh));
    }

    @Benchmark
    public void reqMaxOldCA(Blackhole bh) {
        new MultiConcatArrayOld<Integer>(createPubs())
                .forEach(bh::consume);
    }

    @Benchmark
    public void variableRequestsNewCA(Blackhole bh) {
        new MultiConcatArrayNew<Integer>(createPubs())
                .subscribe(new TestSubscriber(bh));
    }

    @Benchmark
    public void reqMaxNewCA(Blackhole bh) {
        new MultiConcatArrayNew<Integer>(createPubs())
                .forEach(bh::consume);
    }

    static class TestSubscriber implements Flow.Subscriber<Integer> {

        private Flow.Subscription subscription;
        private Blackhole bh;

        public TestSubscriber(final Blackhole bh) {
            this.bh = bh;
        }

        @Override
        public void onSubscribe(final Flow.Subscription subscription) {
            this.subscription = subscription;
        }

        @Override
        public void onNext(final Integer item) {
            subscription.request(item);
            bh.consume(item);
        }

        @Override
        public void onError(final Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            bh.consume(2);
        }
    }
}
