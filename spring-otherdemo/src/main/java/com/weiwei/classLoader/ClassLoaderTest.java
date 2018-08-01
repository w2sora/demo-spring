package com.weiwei.classLoader;

public class ClassLoaderTest {

    public static void main(String[] args) {
        // URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        // for (int i = 0; i < urls.length; i++) {
        //     System.out.println(urls[i].toExternalForm());
        // }

        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extensionLoader = systemLoader.getParent();
        ClassLoader bootstrapLoader = extensionLoader.getParent();
        System.out.println(systemLoader);
        System.out.println(extensionLoader);
        System.out.println(bootstrapLoader); // Bootstrap ClassLoader 不是 Classloader 的子类，而是由JVM实现的
    }

}
