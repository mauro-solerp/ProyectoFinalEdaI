package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utilities.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "remove", mixinStandardHelpOptions = true)
public class CacheRemove implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The key to be removed")
    private String key;

    @CommandLine.Option(names = {"-c", "--collect"}, description = "The collection to be used")
    private String collection = "Default";


    @Override
    public Integer call() {
        new Cache(collection).remove(key);
        System.out.println(true);
        return 0;
    }
}
