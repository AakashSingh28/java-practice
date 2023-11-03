package com.java.multithreading;

public class ThreadDemo {

    public  static void main(String[] args) throws InterruptedException {
        // For extending Thread

        /*MyThread thread=new MyThread();
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("----Main Thread---");
        }*/

        //For implementing Runnable

        /*MyThreadUsingRunnable usingRunnable=new MyThreadUsingRunnable();
        Thread thread=new Thread(usingRunnable);
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("----Main Thread---");
        }*/

        //For Dead Lock

        System.out.println("For Dead Lock");
        Thread.currentThread().join();

        for (int i = 0; i < 100; i++) {
            System.out.println("----Main Thread---");
        }

    }
}
