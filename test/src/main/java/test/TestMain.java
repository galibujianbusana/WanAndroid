package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import test.test2.ProxyHandler;

public class TestMain {
    public static void main(String[] args) {
        // 静态代理
       // HelloProxy  helloProxy = new HelloProxy();
       // helloProxy.sayHello();
        //动态代理
       //  System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        HelloInterface hello = new Hello();

        InvocationHandler handler = new ProxyHandler(hello);

        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);

        proxyHello.sayHello();
    }
}
