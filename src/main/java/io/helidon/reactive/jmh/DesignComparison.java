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

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.helidon.common.reactive.Multi;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;


public class DesignComparison {

    static final int FORKS = 1;

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    static final Collection<Integer> DATA = IntStream.range(0, 1_000_000).boxed().collect(Collectors.toList());

    @Benchmark
    @Fork(FORKS)
    public void multi_maps_strictMode() {
        System.setProperty("helidon.common.reactive.strict.mode", Boolean.TRUE.toString());
        mapTest();
    }

    @Benchmark
    @Fork(FORKS)
    public void multi_maps_noStrictMode() {
        System.setProperty("helidon.common.reactive.strict.mode", Boolean.FALSE.toString());
        mapTest();
    }


    private void mapTest() {
        Multi.just(DATA)
                .map(String::valueOf)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(s -> s)
                .map(BigDecimal::new)
                .map(BigDecimal::intValue)
                .collectList();
    }
}
