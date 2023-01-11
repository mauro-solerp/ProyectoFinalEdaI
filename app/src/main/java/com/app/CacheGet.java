package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utilities.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "get", mixinStandardHelpOptions = true)
public class CacheGet implements Callable<Integer> {

        @CommandLine.Parameters(index = "0", description = "The key to be get")
        private String key;

        @CommandLine.Option(names = {"-c", "--collect"}, description = "The collection to be used")
        private String collection = "Default";

        @Override
        public Integer call() {
            System.out.println(String.format("[Key] >>>> %s \n[Value] >>>> %s", key, new Cache(collection).get(key)));
            return 0;
        }

}
