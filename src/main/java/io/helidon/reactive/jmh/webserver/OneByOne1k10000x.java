package io.helidon.reactive.jmh.webserver;


public class OneByOne1k10000x extends BackPressureComparison{
    
    @Override
    int bufferSize() {
        return 1024;
    }

    @Override
    long streamSize() {
        return 10000;
    }

    @Override
    long requestByN() {
        return 1;
    }
}
