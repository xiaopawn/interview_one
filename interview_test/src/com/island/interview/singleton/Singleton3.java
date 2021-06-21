package com.island.interview.singleton;

/**
 * @author island
 * @version 1.0 2021/6/21 19:51
 */

import java.io.IOException;
import java.util.Properties;

/**
 * 利用静态代码块实现饿汉式 这种方式可以初始化数据用
 */
public class Singleton3 {

    public static final Singleton3 INSTACNE;

    private String info;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("singleton.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        INSTACNE = new Singleton3(properties.getProperty("info"));
    }
    private Singleton3(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
