/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz9_;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author ya
 */
public class FileWorker {
    public static void write(String fileName, String text) {
    //Определяем файл
    File file = new File(fileName);
 
    try {
        //проверяем, что если файл не существует то создаем его
        if(!file.exists()){
            file.createNewFile();
        }
 
        //PrintWriter обеспечит возможности записи в файл
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
 
        try {
            //Записываем текст у файл
            out.print(text);
        } finally {
            
            out.close();
        }
    } catch(IOException e) {
        throw new RuntimeException(e);
    }
}
    
    public static void read(String fileName) {
         try(FileReader reader = new FileReader(fileName))
        {
           // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                 
                System.out.print((char)c);
            } 
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void read(String fileName, Students[] st) throws IOException {

        try  {
            FileInputStream fstream = new FileInputStream(fileName);

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;


            while ((strLine  = br.readLine()) != null)   {

               System.out.println(strLine);
            }
        String [] aa=line.split("|");
        String name = strArray[0];

            br.close ();

            // System.out.print((char)c);
        } 
        catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
    
}


