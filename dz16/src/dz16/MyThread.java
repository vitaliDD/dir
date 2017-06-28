package dz16;

public class MyThread extends Thread {

    public void run() {

        print10(this);
    }

    private static synchronized void print10(Thread th) {
        for (int i = 0; i < 10; i++) {
            System.out.print(th.getName()+" ");

            for (int j = 1; j < 10; j++) {

                System.out.print(j+" ");

            }
            System.out.println();

        }

    }

}
