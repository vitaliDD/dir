package cw16;

import java.util.logging.Level;
import java.util.logging.Logger;



public class MyThread2 extends Thread{

    
    
    
    @Override
    public void run(){
        System.out.println("zapussk mythread2 ");
        for(int i=0;i<6;i++){
             
            if(isInterrupted()){
                System.out.println("mythread stop 1 "+i);
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("mythread stop 2 "+i);
                return;
                
            }
            
        
        }
    
    }
    
}
