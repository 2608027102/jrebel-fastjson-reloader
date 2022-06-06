package com.example.context;

import com.example.config.Config;

import java.lang.reflect.Type;

public class MonitorContext {

    public static boolean matches(Object key) {
        if (key instanceof Type) {
            Type type = (Type) key;
            return type.getTypeName().startsWith(Config.PACKAGE_PREFIX);
        } else {
            return false;
        }
    }
}
