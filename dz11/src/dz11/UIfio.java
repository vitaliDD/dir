package dz11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ya
 */
public class UIfio {

    void hashFIO(Scanner scan) {
        ArrayList<FIO> arrayMan = new ArrayList<>();
        arrayMan.add(new FIO("Ivanov", "Ivan", "Ivanovich"));
        arrayMan.add(new FIO("Petrov", "Petr", "Petrovic"));
        arrayMan.add(new FIO("Sidorov", "Sidr", "Sidorovich"));
        System.out.println(arrayMan.toString());

        ArrayList<FIO> arrayWoman = new ArrayList<>();
        arrayWoman.add(new FIO("Elenova", "Elena", "Elenovna"));
        arrayWoman.add(new FIO("Iriniva", "Irina", "Irinovna"));
        arrayWoman.add(new FIO("Nadezhdina", "Nadezhda", "Nzdezhdovna"));
        System.out.println(arrayWoman.toString());

        HashMap<String, ArrayList<FIO>> hm = new HashMap<>();
        hm.put("MAN", arrayMan);
        hm.put("WOMAN", arrayWoman);
        System.out.println("Vvedite kluch MAN ili WOMAN dlya polychenie randomnogo imeni i td: ");
        String str = "";
        boolean isOk = false;
        do {
            isOk = false;
            str = scan.nextLine();
            if (!str.equals("MAN") && !str.equals("WOMAN")) {
                try {

                    throw new RuntimeException("Nepravino vveli kluch!! Vvedite escho raz:");

                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());

                    isOk = true;
                }
            }
            //finaly
        } while (isOk);
        System.out.println(hm.get(str).get(new Random().nextInt(2)).toString());

    }

}
