package io.helidon.reactive.jmh.engine;

import org.eclipse.microprofile.reactive.streams.operators.spi.ReactiveStreamsEngine;

import java.util.List;

import io.helidon.microprofile.reactive.HelidonReactiveStreamEngine;

public class HelidonRS extends MPRSEnginesComparison<Integer>{

    @Override
    ReactiveStreamsEngine engine() {
        return new HelidonReactiveStreamEngine();
    }

    @Override
    List<Integer> data() {
        return TEST_DATA;
    }
}