
package dz10;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Dz10 {

    public static void main(String[] args) {

        System.out.println("Zadanie 3");
        FileWorker.write("./b.txt", "aaaa|12|true\nbbbb|44|false\neeee|55|true");
        Student[] stud = new Student[3];
        FileWorker.read("./b.txt", stud);
        System.out.println("================");
        System.out.println("Zadanie 1-2");
        boolean isOk = true;
        while (isOk) {
            isOk = false;
            try {
                Calc.Podschet();
            } catch (MyDevideZeroException ex) {
                ex.MyDZeroEx();
                isOk = true;
            } finally {
                if (!isOk) {
                    break;
                }

            }
        }
    }

}
