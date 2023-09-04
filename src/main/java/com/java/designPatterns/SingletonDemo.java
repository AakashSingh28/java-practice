package com.java.designPatterns;

public class SingletonDemo {
    public static void main(String[] args) {

        System.out.println(MySingleton.getInstance().hashCode());
        System.out.println(MySingleton.getInstance().hashCode());
        System.out.println(MySingleton.getInstance().hashCode());

    }
}
