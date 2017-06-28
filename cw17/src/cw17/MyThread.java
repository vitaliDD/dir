package cw17;


public class MyThread extends Thread{

    @Override
    public void run() {

        for(int i=0;i<50;i++){
            Cw17.print10();
           // System.out.println(i+" ");
        }
        

    }
    
    
    
}
