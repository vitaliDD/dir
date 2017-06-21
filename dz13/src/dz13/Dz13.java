package dz13;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Dz13 {

    private static final String FILENAME = "test.json";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Root root = null;
        try {
            root = mapper.readValue(new File(FILENAME), Root.class);

        } catch (Exception ex) {
            System.out.println("oshibka " + ex.toString());
        }
        System.out.println(root.toString());

    }

}
