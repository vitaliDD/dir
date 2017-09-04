/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz5;

/**
 *
 * @author ya
 */
public class Bankomat {

    public Bankomat(int kol_20, int kol_50, int kol_100) {
        this.kol_20 = kol_20;
        this.kol_50 = kol_50;
        this.kol_100 = kol_100;
    }

    private int kol_20;
    private int kol_50;
    private int kol_100;

    public int getKol_20() {
        return kol_20;
    }

    public void setKol_20(int kol_20) {
        this.kol_20 = kol_20;
    }

    public int getKol_50() {
        return kol_50;
    }

    public void setKol_50(int kol_50) {
        this.kol_50 = kol_50;
    }

    public int getKol_100() {
        return kol_100;
    }

    public void setKol_100(int kol_100) {
        this.kol_100 = kol_100;
    }

    public void add_money(int kol_20, int kol_50, int kol_100) {
        setKol_20(getKol_20() + kol_20);
        setKol_50(getKol_50() + kol_50);
        setKol_100(getKol_100() + kol_100);
        System.out.println("V bankomat vsego zagruzheno:\n20rub:  " + this.kol_20 + " sht."
                + "\n50rub:  " + this.kol_50 + " sht."
                + "\n100rub: " + this.kol_100 + " sht.");
        System.out.println("Obschaya summa deneg v bankomate: " + get_info2());

    }

    public boolean get_money(int need_amount) {
        if (need_amount == get_info2()) {
            System.out.println("Vam vidano " + need_amount + " rublei:\n100 - " + kol_100 + "sht.\n"
                + "50 - " + kol_50 + " sht.\n"
                + "20 - " + kol_20 + "sht.");
            kol_100 = 0;
            kol_50 = 0;
            kol_20 = 0;
            
            return true;
        }
        boolean done = true;
        int need_50 = 0, need_20 = 0;
        System.out.println("Zaproshennaya summa: " + need_amount);
        if (get_info2() < need_amount || need_amount < 20||need_amount%10!=0) {
            return false;
        }

        int need_sum_50_100 = need_amount;
        int need_sum_100 = 0;
        while (kol_20 >= need_20) {
            if (need_sum_50_100 == 0 || (((need_sum_50_100) % 50 == 0) && (need_sum_50_100) <= (kol_100 * 100 + kol_50 * 50))) {
              //  kol_20 -= need_20;
                //System.out.println("dostig ysloviya 20");
                break;
            }
            need_20++;
            need_sum_50_100 = need_amount;
            //  System.out.println("need_20 "+need_20);
            need_sum_50_100 -= need_20 * 20;
            //System.out.println("need_sum_50_100 " + need_sum_50_100);

            if (need_20 > kol_20 || (need_sum_50_100 < 20 && need_sum_50_100 != 0)) {
                return false;
            }
        }
        //System.out.println("dostig viddachi 50");
        need_sum_100 = need_sum_50_100;
        while (kol_50 >= need_50) {
            if (/*need_sum_50_100==0||*/(((need_sum_100) % 100 == 0) && (need_sum_100) <= (kol_100 * 100))) {
                //kol_50 -= need_50;
                //System.out.println("dostig ysloviya 50");
                break;
            }
            need_50++;
            need_sum_100 = need_sum_50_100;
           // System.out.println("need_50 " + need_50);
            need_sum_100 -= need_50 * 50;
           // System.out.println("need_sum_100 " + need_sum_100);

            if (need_50 > kol_50) {
                return false;

            }

        }
        kol_100 -= need_sum_100 / 100;
        kol_50 -= need_50;
        kol_20 -= need_20;
        System.out.println("Vam vidano " + need_amount + " rublei:\n100 - " + need_sum_100 / 100 + "sht.\n"
                + "50 - " + need_50 + " sht.\n"
                + "20 - " + need_20 + "sht.");

        //a*kol_100+b*kol_50+c*kol_20=need_amount;
        return done;
    }

    public void get_info() {

        // System.out.println("Summa deneg v bankomate: ");
        System.out.println("Kolichestvo deneg v bankomate:\n20rub:  " + getKol_20() + " sht."
                + "\n50rub:  " + getKol_50() + " sht."
                + "\n100rub: " + getKol_100() + " sht.\n"
                + "Obschaya summa: " + (getKol_20() * 20 + getKol_50() * 50 + getKol_100() * 100) + "rub.");

    }

    public int get_info2() {

        return (getKol_20() * 20 + getKol_50() * 50 + getKol_100() * 100);

    }
}
