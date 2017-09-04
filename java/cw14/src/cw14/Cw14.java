package cw14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cw14 {

    public static void main(String[] args) {

        String str = "+375291234567";
       String str1 = "sdmfnsdm fdfsdaf@tut.by @gmail.com afasfas. a@mail a@mail.";
       // String str1 = "af@343.gg";
        //str1=str1.replaceAll("((\\D)|(\\d))*@((\\D)|(\\d))*\\.(\\D)*", "");
        str1=str1.replaceAll("\\S+@\\S+\\.[a-z]+","");
        System.out.println(str1);
        //Pattern p = Pattern.compile("[0-9]{4}\\s[A-Z]{2}[-][0-7]{1}");
        Pattern p = Pattern.compile("\\+375\\(?(17|25|29|33|44)\\)?[1-9]{1}[0-9]{6}");
        Matcher m = p.matcher(str);
        if (m.matches()) {

            System.out.println("nomer verniy");

        } else {

            System.out.println("nomer NEVERN");

        }
    }

}
