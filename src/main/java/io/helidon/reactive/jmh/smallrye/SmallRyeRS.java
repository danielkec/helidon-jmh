package io.helidon.reactive.jmh.smallrye;

import java.util.List;

import io.smallrye.reactive.streams.Engine;
import org.eclipse.microprofile.reactive.streams.operators.spi.ReactiveStreamsEngine;

public class SmallRyeRS extends MPRSEnginesComparison<Integer> {

    @Override
    ReactiveStreamsEngine engine() {
        return new Engine();
    }

    @Override
    List<Integer> data() {
        return TEST_DATA;
    }
}