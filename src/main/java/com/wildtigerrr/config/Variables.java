package com.wildtigerrr.config;

import java.io.File;

public class Variables {

        private static String path = new File("").getAbsolutePath();

//    for Tomcat
//    public static String path = "E:\\Soft\\Tomcat\\webapps\\restapps-" + Manifests.read("PJversion") + "\\";
//    for Maven
//    public static String path = "E:\\Soft\\IntelliJ IDEA Community Edition 2016.1\\workspace\\resttest"
//            + "\\";


    public static String getPath() {
        return path;
    }
}
