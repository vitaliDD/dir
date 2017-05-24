/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import static java.lang.Math.*;

package dz1;
import static java.lang.Math.*;

/**
 *
 * @author ya
 */
public class Dz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //zadanie 1
        String str1="we all live in a yellow submarine";
        String str2=str1.substring(0,str1.length()/2);
        String str3=str1.substring(str1.length()/2);
        System.out.println(str1+" -- length: "+str1.length());
        System.out.println(str2+" -- length: "+str2.length()+'\n'+str3+
                " -- length: "+str3.length());
        System.out.println("================================");
        //zadanie 2
        int x=346;
        if(x%10==7)
            System.out.println("Posl. cifra 7");
        else 
            System.out.println("Posl. cifra NE 7, a "+x%10);
        System.out.println("================================");
        //zadanie 3
        double a=3;
        double b=4;
        double r=3;
        if(r*2>=sqrt(pow(a,2)+pow(b,2)))
            System.out.println("Mozhno zakrit");
        else
            System.out.println("Nelzya zakrit");
        
        System.out.println("================================");
        
        //zadanie 4
                
        int money=10101984;
        String okonchanie="";
        if(money%100>10&&money%100<20)
            System.out.println(money+" рублей");
        else{
        switch(money%10){
            case 1: okonchanie="рубль";
                break;
            case 2: 
            case 3:
            case 4: okonchanie="рубля";  
                break;
            default: okonchanie="рублей";          
        }
        System.out.println(money+" "+okonchanie);
                
                }
        System.out.println("================================");
        
        //zadanie 5
        String Sstr="fh?kfa#kjk#gF##k???k###";
        Sstr=Sstr.replace("#","").replace("?","HELLO");
        System.out.println(Sstr);
        System.out.println("================================");
        //zadanie 6 / vmesto x budet z
        double y=0;
        int z=4;
        int t=3;
        int s=5;
        y=(pow((sin(pow(x,t))),2))/(sqrt(1+pow(x,s)));
        System.out.println(y);
        
    }
    
}
