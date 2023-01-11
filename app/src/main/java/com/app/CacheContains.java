package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utilities.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "contains", mixinStandardHelpOptions = true)
public class CacheContains implements Callable<Integer> {


    @CommandLine.Parameters(index = "0", description = "The key to be checked")
    private String key;

    @CommandLine.Option(names = {"-c", "--collect"}, description = "The collection to be used")
    private String collection = "Default";

    @Override
    public Integer call() {
        System.out.println(new Cache(collection).exists(key));
        return 0;
    }
}