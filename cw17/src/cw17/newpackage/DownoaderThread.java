/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw17.newpackage;

/**
 * Этот поток скачивает JSON, затем ждет пока его распарсит другой поток,
 * затем скачивает XML и снова ждет пока его распарсит другой поток.
 */
public class DownoaderThread extends Thread{

    private ParserrThread parserrThread;

    public void setParserrThread(ParserrThread parserrThread) {
        this.parserrThread = parserrThread;
    }
    
    @Override
    public void run() {

        //скачиваем JSON
        System.out.println("DownoaderThread - Скачиваем JSON");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        
        synchronized(parserrThread) {
             //пробуждаем поток парсера
            System.out.println("DownoaderThread - пробуждаем поток парсера");
            parserrThread.notifyAll();
       }
        
        // затем сами засыпаем
        synchronized(this) {
            System.out.println("DownoaderThread - сами засыпаем");
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        
        //скачиваем XML
        System.out.println("DownoaderThread - Скачиваем XML");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        
        synchronized(parserrThread) {
             //пробуждаем поток парсера
            System.out.println("DownoaderThread - пробуждаем поток парсера");
            parserrThread.notifyAll();
        }
        
        System.out.println("DownoaderThread - завершаем работу");
    }
}
