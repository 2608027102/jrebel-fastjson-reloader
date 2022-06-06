package com.example.config;

public class Config {

    public static String PACKAGE_PREFIX;

    static {
        PACKAGE_PREFIX = System.getProperty("fastjson.jrebel.package.prefix", "com.yourcompany");
    }

}
