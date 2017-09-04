/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.font.TrueTypeFont;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

/**
 *
 * @author user
 */
public class Cw12 {
    private static final  String LINK="https://tut.by";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        System.out.println(list.toString());
        HashSet<Integer> set=new HashSet<>(list);
        list.clear();
        
        //HttpURLConnection
        
        InputStream inputStream =null;
        FileOutputStream fileOutputStream =null;
        FileOutputStream outputStream=null; 
        try {
            URL url= new URL(LINK);
            
            HttpURLConnection  httpURLConnection = (HttpURLConnection)url.openConnection();
            int responseCode=httpURLConnection.getResponseCode();
            if(responseCode==HttpURLConnection.HTTP_OK){
            
            
            inputStream=httpURLConnection.getInputStream();
            File file =new File ("test.xml");
            outputStream = new FileOutputStream(file);
            
            int bytesRead=-1;//kolichestvo  prochtannih bait za odno chtenie read()
            byte[] buffer = new byte[1024];// to chto skachivaem - poleznaya infa
            while((bytesRead=inputStream.read(buffer))!=-1){
                //zapisivaem v fail bairi ot 0 do "bytesRead" iz massiva "buffer"
                outputStream.write(buffer, 0, bytesRead);
            
            }
            
            
            }
            else{
                 System.out.println("responsecode = "+responseCode);
                         };
            
            
            
        } catch (Exception ex) {
            System.out.println("oshibka"+ex.toString());
        }finally{
            try{
            if(inputStream!=null){
                  
                    inputStream.close();
            }
                
            
            if (outputStream!=null){
                outputStream.close();
            
            }
            }catch(Exception e){
                System.out.println("Oshibka pri zakritii strima");
            }
        }
        
   
        
        
  
                
    }
    
}
