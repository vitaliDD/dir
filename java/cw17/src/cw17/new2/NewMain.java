/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw17.new2;

/**
 *
 * @author user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Potok zapuskaetsya");

                while (true) {

                    if (Thread.currentThread().isInterrupted()) {

                        System.out.println("Potok prervan");
                        return;

                    }
                    try {

                        Thread.sleep(200);

                    } catch (InterruptedException e) {
                      
                        System.out.println("Potok prervan");
                        return;

                    
                    }
                }

            }
        });
        thread.start();

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {
        }

        System.out.println("Prerivaem potok");
        thread.interrupt();

    }

}
