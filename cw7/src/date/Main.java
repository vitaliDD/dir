/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author user
 */
public class Main {
    
    
    public static void main(String [] arg){
    
    Date date=new Date();
    Date date2=new Date();
    
    GregorianCalendar gr=new GregorianCalendar();
    
    
    System.out.println(date.getTime());
    System.out.println(gr.get(GregorianCalendar.DATE));
    System.out.println(gr.get(GregorianCalendar.MONTH));
    System.out.println(gr.get(GregorianCalendar.YEAR));
    gr.add(GregorianCalendar.DATE,45);
    System.out.println(gr.get(GregorianCalendar.DATE));
    System.out.println(gr.get(GregorianCalendar.MONTH));
    System.out.println(gr.get(GregorianCalendar.YEAR));
        SimpleDateFormat sf= new SimpleDateFormat();
        sf.applyPattern("MMMM");
        String dateString = sf.format(date);
        System.out.println(dateString);
    
    }

    
    
}
