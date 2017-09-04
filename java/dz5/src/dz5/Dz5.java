/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz5;

import java.util.Scanner;

/**
 *
 * @author ya
 */
public class Dz5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         
        
        Bankomat bankomat = new Bankomat(10, 0, 10);
        interfaceB(bankomat);
    }

    static void interfaceB(Bankomat bankomat) {
        Scanner scan = new Scanner(System.in);
        for (;;) {
            System.out.println("Viberite operaciyu\n1 - zagruzka deneg v  bankomat\n"
                    + "2 - informaciya o kolichestve deneg v bankomate\n"
                    + "3 - snyatie nalichnyh deneg\n4 - platezhi\n5 - zakonchit raboty");
            switch (scan.nextInt()) {

                case 1:
                    System.out.println("Vvedite kolichestvo kypyur nominalom 100: ");
                    int kol_100 = scan.nextInt();
                    System.out.println("Vvedite kolichestvo kypyur nominalom 50: ");
                    int kol_50 = scan.nextInt();
                    System.out.println("Vvedite kolichestvo kypyur nominalom 20: ");
                    int kol_20 = scan.nextInt();
                    bankomat.add_money(kol_20, kol_50, kol_100);
                    break;
                case 2:
                    bankomat.get_info();
                    break;
                case 3:
                    System.out.println("Vvedite trebuemuyu summu:");
                    int need_sum=scan.nextInt();
                    if(bankomat.get_money(need_sum)){
                        System.out.println("Operaciya provedena yspeshno");
                        System.out.println("Ostatok deneg v bankomate: "+bankomat.get_info2());
                    }
                    else{
                        System.out.println("Oshibka! Trebyemaya summa ne mozhet bit vidana");
                        System.out.println("Ostatok deneg v bankomate: "+bankomat.get_info2());
                    }
                    break;
                case 4:
                    System.out.println("Izvinite, v dannii moment operaciya ne dostypna");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Vi vibrali nevernii nomer operacii");
            }
            String otvet = "";
            otvet = scan.nextLine();
            for (;;) {
                System.out.println("Zhelaete escho odny operaciyu?(yes/no)");
                otvet = scan.nextLine();
                if (otvet.equals("yes") || otvet.equals("no")) {
                    if (otvet.equals("yes")) {
                        break;
                    } else {
                        return;
                    }

                } else {
                    System.out.println("Neverniy vibor deistviya");
                }
            }
        }
    }

}
