package io.helidon.reactive.jmh.webserver;

import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.helidon.common.http.DataChunk;
import io.helidon.common.reactive.IoMulti;
import io.helidon.common.reactive.Multi;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;


public class OneByOne1M100x extends BackPressureComparison{
    
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
        return 1;
    }
}
