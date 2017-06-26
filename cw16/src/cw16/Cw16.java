package cw16;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cw16 {

    /* private static Runnable run = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("thread 1 = " + i);
            }

        }
    };*/
    public static void main(String[] args) throws InterruptedException {

        /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("thread 1 = " + i);
                }
            }
        });
        
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("thread 2 = " + i);
        
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        });
        thread.start();
        thread2.start();
    }

    public static void main2(String[] args) {

        Thread thread = new Thread(run);

        thread.start();
         */
        //MyThread mythread=new MyThread();
        MyThread2 mythread2 = new MyThread2();
        mythread2.start();
        try{
            mythread2.join();
        
        }catch(InterruptedException ex){
        
        
        }
        Thread.sleep(2000);
        // mythread.setDaemon(true);
        mythread2.interrupt();

    }

    public synchronized static void print10() {

        for (int i = 0; i < 100; i++) {

            System.out.println("mythread name " + i);

        }

    }
}
