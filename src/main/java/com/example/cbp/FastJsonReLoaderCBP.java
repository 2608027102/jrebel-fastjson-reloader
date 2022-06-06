package com.example.cbp;

import org.zeroturnaround.bundled.javassist.ClassPool;
import org.zeroturnaround.bundled.javassist.CtClass;
import org.zeroturnaround.javarebel.integration.support.JavassistClassBytecodeProcessor;

public class FastJsonReLoaderCBP extends JavassistClassBytecodeProcessor {
    @Override
    public void process(ClassPool classPool, ClassLoader classLoader, CtClass ctClass) throws Exception {
        classPool.importPackage("com.example.context");

        // language=TEXT
        String statement = "if (MonitorContext.matches($1)) {\n" +
                "    return null;\n" +
                "}";

        ctClass.getDeclaredMethod("get")
                .insertBefore(statement);
    }

}
