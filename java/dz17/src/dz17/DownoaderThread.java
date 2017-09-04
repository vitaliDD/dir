package dz17;

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
          System.err.println("DownoaderThread vol "+Dz17.getDz17().vol);
          Dz17.getDz17().vol++;
        //скачиваем JSON
       System.out.println("DownoaderThread - Скачиваем JSON");
       /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
       */
        
        new InternetDownload(2).download();
        synchronized(parserrThread) {
             //пробуждаем поток парсера
            System.out.println("DownoaderThread - пробуждаем поток парсера");
            parserrThread.notifyAll();
       }
           System.err.println("DownoaderThread vol "+Dz17.getDz17().vol);
        // затем сами засыпаем
        synchronized(this) {
            System.out.println("DownoaderThread - сами засыпаем");
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        
        //скачиваем XML
        System.out.println("DownoaderThread - Скачиваем XML");
        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        */  
         new InternetDownload(1).download();
        
        synchronized(parserrThread) {
             //пробуждаем поток парсера
            System.out.println("DownoaderThread - пробуждаем поток парсера");
            parserrThread.notifyAll();
        }
        
        System.out.println("DownoaderThread - завершаем работу");
    }
}
