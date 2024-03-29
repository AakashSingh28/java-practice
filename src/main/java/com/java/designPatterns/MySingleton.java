package com.java.designPatterns;

public class MySingleton {

    private static MySingleton INSTANCE;
    private MySingleton(){
    }
    public static MySingleton getInstance(){
        if (INSTANCE==null){
            synchronized (MySingleton.class){
                if(INSTANCE==null){
                    INSTANCE=new MySingleton();
                }
            }
        }
        return INSTANCE;
    }


}
