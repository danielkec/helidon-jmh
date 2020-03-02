package io.helidon.reactive.jmh.multi;

import io.helidon.common.reactive.Multi;
import io.helidon.common.reactive.MultiOldDesign;

public class OldMulti extends MultiComparison {
    @Override
    Multi<Integer> multi() {
        return MultiOldDesign.from(TEST_DATA);
    }
}
