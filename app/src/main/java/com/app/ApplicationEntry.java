package com.app;
import picocli.CommandLine;

public class ApplicationEntry{
    public static void main(String[] args){
        int exitCode = new CommandLine(new ApplicationMain())
                .addSubcommand(new CacheContains())
                .addSubcommand(new CacheCreate())
                .addSubcommand(new CacheGet())
                .addSubcommand(new CacheGetAll())
                .addSubcommand(new CacheRemove())
                .addSubcommand(new CacheUpdate())
                .execute(args);
        System.exit(exitCode);
    }
}