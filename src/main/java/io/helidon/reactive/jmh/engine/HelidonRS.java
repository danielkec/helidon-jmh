package io.helidon.reactive.jmh.engine;

import java.util.List;

import io.helidon.microprofile.reactive.HelidonReactivePublisherFactory;
import io.helidon.microprofile.reactive.HelidonReactiveStreamsEngine;

import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.spi.ReactiveStreamsEngine;

public class HelidonRS extends MPRSEnginesComparison<Integer>{

    @Override
    ReactiveStreamsEngine engine() {
        return new HelidonReactiveStreamsEngine();
    }

    @Override
    PublisherBuilder<Integer> rs() {
        return HelidonReactivePublisherFactory.INSTANCE.fromIterable(data());
    }

    @Override
    List<Integer> data() {
        return TEST_DATA;
    }
}