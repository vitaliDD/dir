package dz17;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author ya
 */
public class JSONParse implements ParseFile {

    private static final String FILENAME = "hospital.json";

    @Override
    public ArrayList<Doctors> parse() {
        System.out.println("json parsing START!");
        ObjectMapper mapper = new ObjectMapper();
        Root root = null;
        try {
            root = mapper.readValue(new File(FILENAME), Root.class);

        } catch (Exception ex) {
            System.err.println("Oshibka parsinga" + ex.toString());

        }
        if (root.getDoctors() != null) {
            System.out.println("json parsing proshel uspeshno!");
        }
        // System.out.println(root.getDoctors().toString());

        for (Doctors e : root.getDoctors()) {
            System.out.println(e.toString());
        }
        return root.getDoctors();

    }

}
