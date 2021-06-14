package io.helidon.reactive.jmh.webserver;


public class Unbounded1k100x extends BackPressureComparison{
    
    @Override
    int bufferSize() {
        return 1024;
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
