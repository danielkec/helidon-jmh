package io.helidon.reactive.jmh.multi;

import io.helidon.common.reactive.Multi;

public class NewMulti extends MultiComparison{
    @Override
    Multi<Integer> multi() {
        return Multi.from(TEST_DATA);
    }
}
