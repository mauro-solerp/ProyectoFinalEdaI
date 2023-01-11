package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utilities.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "getAll", mixinStandardHelpOptions = true)
public class CacheGetAll implements Callable<Integer> {
        @CommandLine.Option(names = {"-s","--size"}, description = "If return size of the collection")
        private boolean count;

        @CommandLine.Option(names = {"-c", "--collect"}, description = "The collection to be used")
        private String collection = "Default";

        @Override
        public Integer call() {
            Cache cache = new Cache(collection);
            if (count == false) {
                for (String key : cache.getAll()) {
                    System.out.println(String.format("[Key] >>>> %s \n[Value] >>>> %s \n\n" +
                            "---------------------------------------------------------------------------\n", key, cache.get(key)));
                }
            } else {
                System.out.println(cache.size());
            }
            return 0;
        }

}