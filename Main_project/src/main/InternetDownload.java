package main;

import com.sun.webkit.ThemeClient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class InternetDownload extends Thread{

   
        
        
        
    

    private static final String LINK_XML = "http://kiparo.ru/t/hospital.xml";
    private static final String LINK_JSON = "http://kiparo.ru/t/hospital.json";
    private int intLink;
    static boolean dFlag=false;

    public InternetDownload(int intLink) {
        this.intLink = intLink;
    }
    
    public void run() {
        dFlag=false;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        URL url = null;
        File file = null;
        try {
            switch (intLink) {

                case 1:
                    url = new URL(LINK_XML);//vibor XML
                    file = new File("hospital.xml");
                    break;
                case 2:
                    url = new URL(LINK_JSON);//vibor XML
                    file = new File("hospital.json");
                    break;
            }
            
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                outputStream = new FileOutputStream(file);
                int bytesRead = -1;//kolichestvo  prochitannih bait za odno chtenie read()
                byte[] buffer = new byte[1024];// to chto skachivaem - poleznaya infa
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    //zapisivaem v fail bairi ot 0 do "bytesRead" iz massiva "buffer"
                    outputStream.write(buffer, 0, bytesRead);
                }
            } else {
                System.out.println("responsecode = " + responseCode);
            };
        } catch (Exception ex) {
            System.err.println("oshibka skachinaniya, server nedostupen: " + ex.toString());
            dFlag=true;
            
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                System.err.println("Oshibka pri zakritii strima "+e.toString());
            }
        }

    }

}
