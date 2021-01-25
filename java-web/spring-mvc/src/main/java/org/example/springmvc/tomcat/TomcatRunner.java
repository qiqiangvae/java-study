package org.example.springmvc.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

/**
 * @author qiqiang
 * @date 2020-12-20 19:52
 */
public class TomcatRunner {
    public static void main(String[] args) throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);
        tomcat.addWebapp("/", "/");
        tomcat.start();
        tomcat.getServer().await();
    }
}