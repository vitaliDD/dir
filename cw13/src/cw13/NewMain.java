
package cw13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String str= "2017 AB-7";
        
        Pattern p= Pattern.compile("[0-9]{4}\\s[A-Z]{2}[-][0-7]{1}");
        Matcher m=p.matcher(str);
        if(m.matches()){
        
            System.out.println("nomer verniy");
        
        }
        else {
            
            System.out.println("nomer NEVERN");
        
        
        }

    }
    
}
