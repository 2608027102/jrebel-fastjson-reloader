package com.example.config;

public class Config {

    public static String PACKAGE_PREFIX;

    static {
        PACKAGE_PREFIX = System.getProperty("jrebel.fastjson.package.prefix", "com.yourcompany");
    }

    public static String getConfigMessage() {
        return String.format("+-------------------------------------------------+\n" +
                "+-- package.prefix = %s\n" +
                "+-------------------------------------------------+", PACKAGE_PREFIX);
    }

}
