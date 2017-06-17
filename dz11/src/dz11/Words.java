package dz11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ya
 */
public class Words {

    void doColl(Scanner scan) {
        ArrayList<String> arrayList = new ArrayList<>();
        //Scanner scan = new Scanner(System.in);
        System.out.println("Vvedite slovo, nazhmite ENTER,\nkogda nodoest nazhmite '~'");
        while (true) {
            String word = scan.nextLine();
            if (word.equals("~")) {
                break;
            }
            arrayList.add(word);
        }
        System.out.println("Razmer massiva: " + arrayList.size());
        System.out.println("Soderzhimoe massiva: " + arrayList.toString());
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).contains("a")) {
                arrayList.set(i, arrayList.get(i).replaceAll("a", ""));
                if (arrayList.get(i).equals("")) {
                    arrayList.remove("");//убираем пустые элементы
                }
            }
        }
        System.out.println("Soderzhimoe massiva posle uborki 'a': " + arrayList.toString());
        System.out.println("Soderzhimoe massiva polse udaleniya dublicatov: " +
                new HashSet(arrayList).toString());//zadanie 2
    }

}
