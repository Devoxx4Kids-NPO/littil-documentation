package org.littil.mockbackend;

import com.intuit.karate.core.MockServer;

public class BackendRunner {

    public static void main(String[] args) {
        MockServer build = MockServer.feature("classpath:teacher.feature").http(8090).build();
    }
}
