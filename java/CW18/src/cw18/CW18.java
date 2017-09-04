package cw18;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CW18 {

    public static void main(String[] args) {
//типизация методов и классов
        StaffCollection<PVTPeople> staf = new StaffCollection<>();

        test("ffff", String.class);

    }

    public static <T extends Object> T test(String text, T t) {
        T o = null;
        try {
            o = (T) t.getClass().newInstance();

        } catch (Exception ex) {
        }
        return o;
    }
}
