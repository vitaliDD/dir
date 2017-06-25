package dz14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dz14 {

    public static void main(String[] args) {
        System.out.println("======================");
        System.out.println("Zadanie 0");
        System.out.println("======================");

        String telef = "+375291347567";
        String auto = "1238 AB-7";
        String email = "fdfsdaf@12.by sdmfnsdm fdfsdaf@tut.by @gmail.com afasfas. a@mail a@mail. fdfsdaf@tut.by";
        email = email.replaceAll("\\S+@\\S+\\.[a-z]+", "");
        System.out.println(email);

        Pattern pAUTO = Pattern.compile("[0-9]{4}\\s[A-Z]{2}[-][0-7]{1}");
        Matcher mAuto = pAUTO.matcher(auto);
        if (mAuto.matches()) {

            System.out.println("nomer auto verniy");

        } else {

            System.out.println("nomer auto  NEVERN");

        }

        Pattern pNumber = Pattern.compile("\\+375\\(?(17|25|29|33|44)\\)?[1-9]{1}[0-9]{6}");
        Matcher mNumber = pNumber.matcher(telef);
        //   System.out.println(mNumber.toString());
        if (mNumber.matches()) {

            System.out.println("nomer telefona verniy");

        } else {

            System.out.println("nomer telefona NEVERN");

        }

        System.out.println("======================");

        System.out.println("Zadanie 2");
        String sFormat = "sfdtwe4333r-sgs.jsfon";

        System.out.println(sFormat);

        sFormat = sFormat.replaceAll("\\S+\\.", "");

        try {
            if (sFormat.equals("xml")) {

                System.out.println("Format xml");

            } else if (sFormat.equals("json")) {

                System.out.println("Format json");

            } else {
                throw new Exception("Vse ploho!!! Neverniy format: " + sFormat);

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("======================");
        System.out.println("Zadanie 1");
        // String s3="hellowoooorld";
        //  System.out.println(s3.replace("", "-"));
        String str = "hellowoooorld hoo bgbgbgffb dscdscdscsrrttrrtrr";
        char[] array = str.toCharArray();


        char c = '\u0000';
    

        //mult - счетчик для кол-ва повторений
        int mult = 1;
        //b - внутенний счетчик для внутреннего цикла 
        int b;
        StringBuilder result = new StringBuilder();
        //считаем количество повторений
        for (int i = 0; i < array.length; i++) {

            if (c == (array[i])) {
                mult += 1;
                b = i + 1;
                for (int a = b; a < array.length; a++) {

                    if (c == array[a]) {
                        mult += 1;
                    } else {
                        break;
                    }
                }
                result.append(mult);
                mult = 1;
            } else {
                result.append(array[i]);
                c = array[i];
            }
        }
        System.out.println("Start is = " + str);
        //System.out.println("result is = " + result);

        //удаляем все ненужные числа с помощью регулярных выражений
        String finalResult = result.toString().replaceAll("(?<=\\d{1})\\d*", "");
        System.out.println("FinalResult is = " + finalResult);

    }

}
