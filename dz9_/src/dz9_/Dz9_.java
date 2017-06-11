/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz9_;

/**
 *
 * @author ya
 */
public class Dz9_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Zadanie 1");
        UI ui = new UI();
        ui.startUI();
        // TODO code application logic here
        System.out.println("=============");
        System.out.println("Zadanie 2");
        String text = "This new text\nThis new text2\nThis new text3\nThis new text4\n";
        String fileName = "./b.txt";
        FileWorker.write(fileName, text);
        FileWorker.read(fileName);
         
        System.out.println("Zadanie 3");
        System.out.println("=============");
        // City Minsk=new City(new City.Name("Pushkina"), new City.Name("Skriganova"), new City.Name("Pobedy"));
        // City.Name c1=;
         
        City Mogilev=new City("Przevalskogo","Lenina","Pobedy","Mogilev");//конструктор с параметрами полей name 
        City Minsk=new City("Minsk");//
                 
         //различные способы задания полей
         Minsk.setNameProspect(Minsk.new Name("Pushkina"));
         City.Name nn=Minsk.new Name("Kazinca");
         Minsk.setNamePloschad(nn);
         Minsk.setNameUlica(Minsk.new Name("Skriganova"));
         
        System.out.println(Mogilev.toString());
        System.out.println(Minsk.toString());
       
    }
    
}
