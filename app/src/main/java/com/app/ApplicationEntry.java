package com.app;
import picocli.CommandLine;

public class ApplicationEntry{
    public static void main(String[] args){
        int exitCode = new CommandLine(new Application()).execute(args);
        System.exit(exitCode);
    }
}