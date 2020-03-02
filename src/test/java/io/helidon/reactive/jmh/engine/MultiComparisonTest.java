package io.helidon.reactive.jmh.engine;

import io.helidon.reactive.jmh.multi.MultiComparison;

import org.junit.jupiter.api.Test;

class MultiComparisonTest {
    @Test
    void helidonVsSmallRye() throws Exception {
        MultiComparison.main(new String[0]);
    }
}