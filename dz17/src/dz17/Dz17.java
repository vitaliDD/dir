package dz17;

public class Dz17 {
    private static Dz17 dz17;
   /* volatile*/ int vol=5;
    private Dz17(){}
       public static synchronized Dz17 getDz17() {
        if (dz17 == null) {
            dz17 = new Dz17();
        }
        return dz17;
    }
    

    public static void main(String[] args) throws InterruptedException {
 
       // Dz17 dz17=new Dz17();
        System.out.println("Zadanie 1");
        DownoaderThread downloaderT = new DownoaderThread();
        ParserrThread parserT = new ParserrThread();

        downloaderT.setParserrThread(parserT);
        parserT.setDownoaderThread(downloaderT);

        parserT.start();
        downloaderT.start();
        Dz17.getDz17().vol++;
        downloaderT.join();
        parserT.join();
        Dz17.getDz17().vol++;
        System.out.println("Zadanie 2");
        System.out.println("======================================");
        //sdelano v peremennoi vol v etom klasse;

    }

}
