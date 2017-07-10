package parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import data.Doctors;
import data.Root;

/**
 *
 * @author ya
 */
public class JSONParse implements ParseFile {

    private static final String FILENAME = "hospital.json";

    @Override
    public ArrayList<Doctors> parse() {
        System.out.println("JSON parsing START!");
        ObjectMapper mapper = new ObjectMapper();
        Root root = null;
        try {
            root = mapper.readValue(new File(FILENAME), Root.class);

        } catch (Exception ex) {
            System.err.println("Oshibka parsinga: 1" + ex.toString());
            return null;
        }
        if(root.getDoctors()!=null)
        System.out.println("json parsing proshel uspeshno!");
        
        return root.getDoctors();
        
    }

}
