package io.helidon.reactive.jmh.webserver;


public class Unbounded1M100x extends BackPressureComparison{
    
    @Override
    int bufferSize() {
        return 10 * 1024 * 1024;
    }

    @Override
    long streamSize() {
        return 100;
    }

    @Override
    long requestByN() {
        return Long.MAX_VALUE;
    }
}
