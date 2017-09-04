package cw16;

import java.util.logging.Level;
import java.util.logging.Logger;



public class MyThread extends Thread{
    private boolean isFinish=false;

    public void setIsFinish(boolean isFinish) {
        this.isFinish = isFinish;
    }
    
    
    
    @Override
    public void run(){
      
        for(int i=0;i<10;i++){
            if(isFinish)
            {
                return;
            
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                
                
            }
            
        System.out.println("methread "+i);
        }
    
    }
    
}
