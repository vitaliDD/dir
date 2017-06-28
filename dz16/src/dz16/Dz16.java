package dz16;

public class Dz16 {

    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        thread1.setName("Thread 1:");

        MyThread thread2 = new MyThread();
        thread2.setName("Thread 2:");
        
        thread1.start();
        thread2.start();

    }

}
