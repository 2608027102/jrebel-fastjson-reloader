## 功能简介

解决使用JRebel+FastJson作为Controller序列化工具时，修改DTO字段后导致FastJson序列化失败的问题

在JVM参数中增加以下内容

```
-Drebel.plugins=/path/to/jrebel-fastjson-reloader-1.0-SNAPSHOT.jar
-Dfastjson.jrebel.package.prefix=com.yourcompany
```

- `rebel.plugins`: 指定插件的位置  
- `fastjson.jrebel.package.prefix`: 指定需要拦截的包名前缀

该插件的原理为：

- 拦截`com.alibaba.fastjson.util.IdentityHashMap::get`方法
- 在方法执行前校验参数的包名是否为指定前缀，如果是则直接返回null
- 避免FastJson缓存导致字段变动后，仍使用旧的序列化器从而导致序列化失败的问题