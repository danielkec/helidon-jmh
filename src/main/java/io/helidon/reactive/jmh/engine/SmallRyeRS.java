package io.helidon.reactive.jmh.engine;

import java.util.List;

import io.smallrye.reactive.streams.Engine;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;
import org.eclipse.microprofile.reactive.streams.operators.spi.ReactiveStreamsEngine;

public class SmallRyeRS extends MPRSEnginesComparison<Integer> {

    @Override
    ReactiveStreamsEngine engine() {
        return new Engine();
    }

    @Override
    PublisherBuilder<Integer> rs() {
        return ReactiveStreams.fromIterable(data());
    }

    @Override
    List<Integer> data() {
        return TEST_DATA;
    }
}