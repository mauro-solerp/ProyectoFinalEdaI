package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utilities.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "update", mixinStandardHelpOptions = true)
public class CacheUpdate implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The key to be updated")
    private String key;

    @CommandLine.Parameters(index = "1", description = "The new value")
    private String value;

    @CommandLine.Option(names = {"-c", "--collect"}, description = "The collection to be used")
    private String collection = "Default";

    @Override
    public Integer call() {
        new Cache(collection).put(key, value);
        System.out.println(String.format("[Key] >>>> %s \n[Value] >>>> %s", key, value));
        return 0;
    }
}
