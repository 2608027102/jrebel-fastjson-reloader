package com.example;

import com.example.cbp.FastJsonReLoaderCBP;
import org.zeroturnaround.javarebel.ClassResourceSource;
import org.zeroturnaround.javarebel.Integration;
import org.zeroturnaround.javarebel.IntegrationFactory;
import org.zeroturnaround.javarebel.Logger;
import org.zeroturnaround.javarebel.LoggerFactory;
import org.zeroturnaround.javarebel.Plugin;

public class FastJsonPlugin implements Plugin {

    private static final Logger logger = LoggerFactory.getInstance();

    private static final String[] CLASSES = {
            "com.alibaba.fastjson.util.IdentityHashMap"
    };

    @Override
    public void preinit() {
        Integration integration = IntegrationFactory.getInstance();
        ClassLoader cl = getClass().getClassLoader();

        logger.echo("FastJson-JRebel插件启用, 配置详情");
        for (String aClass : CLASSES) {
            integration.addIntegrationProcessor(
                    cl,
                    aClass,
                    new FastJsonReLoaderCBP());
        }
    }

    @Override
    public boolean checkDependencies(ClassLoader classLoader, ClassResourceSource classResourceSource) {
        boolean hasDependencies = false;
        for (String aClass : CLASSES) {
            if (classResourceSource.getClassResource(aClass) != null) {
                hasDependencies = true;
                break;
            }
        }
        return hasDependencies;
    }

    @Override
    public String getId() {
        return "jrebel-fastjson-reloader-plugin";
    }

    @Override
    public String getName() {
        return "jrebel-fastjson-reloader";
    }

    @Override
    public String getDescription() {
        return "jrebel-fastjson-reloader";
    }

    @Override
    public String getAuthor() {
        return "wjl";
    }

    @Override
    public String getWebsite() {
        return null;
    }

    @Override
    public String getSupportedVersions() {
        return null;
    }

    @Override
    public String getTestedVersions() {
        return null;
    }
}
