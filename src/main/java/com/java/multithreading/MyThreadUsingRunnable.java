package com.java.multithreading;

public class MyThreadUsingRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("----ChildThread---");
        //    Thread.yield();  // It will give chance to other Thread to execute
        }
    }
}
