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
         File fstream = new File(fileName);
        try  {
           

            BufferedReader br = new BufferedReader(new FileReader(fstream.getAbsoluteFile()));

            String strLine;
            int kol=st.length;
            int i=0;
            

            while ((strLine  = br.readLine()) != null)   {
                
                 String[] aa=strLine.split("|");
                 st[0].setName(aa[0]);
                // System.out.print(aa[1]);
                
              // System.out.println(strLine);
            }
            System.out.println(st[0].getName());
           // String name = strArray[0];
           //System.out.print(aa);
            br.close ();
            

            // System.out.print((char)c);
        } 
        catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
    
}


