package com.app;

import java.util.concurrent.Callable;

public class Application implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // Nothing to do...yet
        return 0; //zero: everything is ok.
    }
}