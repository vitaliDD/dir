package dz11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Dz11 {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("Zadanie 1-2");
        Words words=new Words();
        words.doColl(scan);
        System.out.println("========================");
        System.out.println("Zadanie 3");
        UIfio fio= new UIfio();
        fio.hashFIO(scan);
        
        
        
        
    }

}
