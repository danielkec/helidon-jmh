package io.helidon.reactive.jmh.engine;

import org.eclipse.microprofile.reactive.streams.operators.spi.ReactiveStreamsEngine;

import java.util.List;

import io.helidon.microprofile.reactive.HelidonReactiveStreamsEngine;

public class HelidonRS extends MPRSEnginesComparison<Integer>{

    @Override
    ReactiveStreamsEngine engine() {
        return new HelidonReactiveStreamsEngine();
    }

    @Override
    List<Integer> data() {
        return TEST_DATA;
    }
}