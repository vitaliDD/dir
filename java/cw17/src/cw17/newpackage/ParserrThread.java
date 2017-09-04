/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw17.newpackage;

/**
 * Этот поток жлет пока другой поток скачает JSON, затем парсит его,
 * затем ждет пока другой поток скачает XML и парсит его
 */
public class ParserrThread extends Thread{

    private DownoaderThread downoaderThread;

    public void setDownoaderThread(DownoaderThread downoaderThread) {
        this.downoaderThread = downoaderThread;
    }

    @Override
    public void run() {
        
         // засыпаем и ждем пока поток downoaderThread не вызовет у нас notify()
        synchronized(this) {
            System.out.println("ParserrThread - сами засыпаем");
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        
         //парсим JSON
        System.out.println("ParserrThread - Парсим JSON");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        
        
        System.out.println("ParserrThread - Завершаем работу");
    }
}

