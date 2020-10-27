package io.helidon.reactive.jmh.engine;

import java.util.List;

import org.eclipse.microprofile.reactive.streams.operators.spi.ReactiveStreamsEngine;

public class MutinyRS extends MPRSEnginesComparison<Integer> {
    @Override
    ReactiveStreamsEngine engine() {
        return new io.smallrye.mutiny.streams.Engine();
    }

    @Override
    List<Integer> data() {
        return TEST_DATA;
    }

}
