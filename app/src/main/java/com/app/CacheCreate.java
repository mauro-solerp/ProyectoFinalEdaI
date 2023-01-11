package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utilities.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "create", mixinStandardHelpOptions = true)
public class CacheCreate implements Callable<Integer> {

        @CommandLine.Parameters(index = "0", description = "The new key")
        private String key;


        @CommandLine.Parameters(index = "1", description = "The value to be added")
        private String value;

        @CommandLine.Option(names = {"-c", "--collect"}, description = "The collection to be used")
        private String collection = "Default";

    @Override
        public Integer call() throws Exception {
            new Cache(collection).addNew(key, value);
            System.out.println(String.format("[Key] >>>> %s \n[Value] >>>> %s", key, value));
            return 0;
        }
}
