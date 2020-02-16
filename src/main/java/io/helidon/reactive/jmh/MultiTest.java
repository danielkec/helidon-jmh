/*
 * Copyright (c)  2020 Oracle and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.helidon.reactive.jmh;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.helidon.common.mapper.Mapper;
import io.helidon.common.reactive.Collector;
import io.helidon.common.reactive.Multi;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


public class MultiTest {


    public static void main(String[] args) throws Exception {
        System.setProperty("helidon.common.reactive.strict.mode", Boolean.TRUE.toString());
        Options opt = new OptionsBuilder()
                .include(MultiTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    static final List<String> TEST_DATA = IntStream.range(0, 1_000_000)
            .mapToObj(i -> String.format("%d%d%d%d%d", i, i, i, i, i))
            .collect(Collectors.toList());

    @Benchmark
    public void testJust() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.<String>just("foo", "bar").subscribe(subscriber);
    }

    @Benchmark
    public void testJustWithLoad() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.<String>just(TEST_DATA).subscribe(subscriber);
    }

    @Benchmark
    public void testEmpty() {
        MultiTestSubscriber<Object> subscriber = new MultiTestSubscriber<>();
        Multi.<Object>empty().subscribe(subscriber);
    }

    @Benchmark
    public void testError() {
        MultiTestSubscriber<Object> subscriber = new MultiTestSubscriber<>();
        Multi.<Object>error(new Exception("foo")).subscribe(subscriber);
    }

    @Benchmark
    public void testNever() {
        MultiTestSubscriber<Object> subscriber = new MultiTestSubscriber<>();
        Multi.<Object>never().subscribe(subscriber);
    }

    @Benchmark
    public void testMapper() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.just("foo", "bar").map(String::toUpperCase).subscribe(subscriber);
    }

    @Benchmark
    public void testMapperWithLoad() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.just(TEST_DATA).map(String::toUpperCase).subscribe(subscriber);
    }

    @Benchmark
    public void testErrorCollect() {
        MultiTestSubscriber<List<String>> subscriber = new MultiTestSubscriber<>();
        Multi.<String>error(new Exception("foo")).collectList().subscribe(subscriber);
    }

    @Benchmark
    public void testCollectList() {
        MultiTestSubscriber<List<String>> subscriber = new MultiTestSubscriber<>();
        Multi.just("foo", "bar").collectList().subscribe(subscriber);
    }

    @Benchmark
    public void testCollectListWithLoad() {
        MultiTestSubscriber<List<String>> subscriber = new MultiTestSubscriber<>();
        Multi.just(TEST_DATA).collectList().subscribe(subscriber);
    }

    @Benchmark
    public void testFromPublisher() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.from(new TestPublisher<>("foo", "bar")).subscribe(subscriber);
    }

    @Benchmark
    public void testFromPublisherWithLoad() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.from(new TestPublisher<>(TEST_DATA.toArray(new String[0]))).subscribe(subscriber);
    }

    @Benchmark
    public void testFromMulti() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.from(Multi.<String>just("foo", "bar")).subscribe(subscriber);
    }

    @Benchmark
    public void testFromMultiWithLoad() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.from(Multi.<String>just(TEST_DATA)).subscribe(subscriber);
    }

    @Benchmark
    public void testFirst() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.just("foo", "bar").first().subscribe(subscriber);
    }

    @Benchmark
    public void testFirstWithLoad() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.just(TEST_DATA).first().subscribe(subscriber);
    }

    @Benchmark
    public void testErrorFirst() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.<String>error(new IllegalStateException("foo!")).first().subscribe(subscriber);
    }

    @Benchmark
    public void testCollectorBadCollectMethod() {
        MultiTestSubscriber<List<String>> subscriber = new MultiTestSubscriber<>();
        Multi.<String>just("foo", "bar").collect(new Collector<String, List<String>>() {
            @Override
            public void collect(String item) {
                throw new IllegalStateException("foo!");
            }

            @Override
            public List<String> value() {
                return Collections.emptyList();
            }
        }).subscribe(subscriber);
    }

    @Benchmark
    public void testCollectorBadValueMethod() {
        MultiTestSubscriber<List<String>> subscriber = new MultiTestSubscriber<>();
        Multi.<String>just("foo", "bar").collect(new Collector<String, List<String>>() {
            @Override
            public void collect(String item) {
            }

            @Override
            public List<String> value() {
                throw new IllegalStateException("foo!");
            }
        }).subscribe(subscriber);
    }

    @Benchmark
    public void testCollectorBadNullValue() {
        MultiTestSubscriber<List<String>> subscriber = new MultiTestSubscriber<>();
        Multi.<String>just("foo", "bar").collect(new Collector<String, List<String>>() {
            @Override
            public void collect(String item) {
            }

            @Override
            public List<String> value() {
                return null;
            }
        }).subscribe(subscriber);
    }

    @Benchmark
    public void testNeverMap() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<String>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                subscription.request(1);
                subscription.request(1);
            }
        };
        Multi.<String>never().map(String::toUpperCase).subscribe(subscriber);
    }

    @Benchmark
    public void testMapBadMapper() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.<String>just("foo", "bar").map(new Mapper<String, String>() {
            @Override
            public String map(String item) {
                throw new IllegalStateException("foo!");
            }
        }).subscribe(subscriber);
    }

    @Benchmark
    public void testMapBadMapperNullValue() {
        MultiTestSubscriber<String> subscriber = new MultiTestSubscriber<>();
        Multi.just("foo", "bar").map((Mapper<String, String>) item -> null).subscribe(subscriber);
    }

    @Benchmark
    public void testMapChain() {
        Multi.just(TEST_DATA)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .collectList();
    }

    private static class MultiTestSubscriber<T> extends TestSubscriber<T> {

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            super.onSubscribe(subscription);
            requestMax();
        }
    }
}
