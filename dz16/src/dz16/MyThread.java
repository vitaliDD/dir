package dz16;

public class MyThread extends Thread {

    public void run() {

        print10();
    }

    private  synchronized void print10() {
        for (int i = 0; i < 10; i++) {
            System.out.print(this.getName()+" ");

            for (int j = 1; j < 10; j++) {

                System.out.print(j+" ");

            }
            System.out.println();

        }

    }

}
