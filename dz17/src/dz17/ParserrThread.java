/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz17;

/**
 * Этот поток жлет пока другой поток скачает JSON, затем парсит его,
 * затем ждет пока другой поток скачает XML и парсит его
 */
public class ParserrThread extends Thread{

    private DownoaderThread downoaderThread;
    ParseFile pf;
    
    public void setDownoaderThread(DownoaderThread downoaderThread) {
        this.downoaderThread = downoaderThread;
    }

    @Override
    public void run() {
          System.err.println("ParserrThread vol "+Dz17.getDz17().vol);
          Dz17.getDz17().vol++;
         // засыпаем и ждем пока поток downoaderThread не вызовет у нас notify()
        synchronized(this) {
            System.out.println("ParserrThread - сами засыпаем");
            
            try {
                wait();
                
                System.out.println("ParserrThread -  DOLZHNO bit' vidno posle downloader");
            } catch (InterruptedException ex) {}
            
        }
        
         //парсим JSON
        System.out.println("ParserrThread - Парсим JSON");
        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        */
        pf=new JSONParse();
        pf.parse();
        
         synchronized(downoaderThread) {
             //пробуждаем поток скачки
            System.out.println("ParserrThread - пробуждаем поток скачивания");
            downoaderThread.notifyAll();
        }
         
         synchronized(this) {
            // затем сами засыпаем
            System.out.println("ParserrThread - сами засыпаем");
            try {
                wait();
            } catch (InterruptedException ex) {}
          }
         
        //парсим XML
        System.out.println("ParserrThread - Парсим XML");
        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        */
        pf=new XMLParse();
        pf.parse();
        
        System.out.println("ParserrThread - Завершаем работу");
    }
}

