

package sort;

import java.util.Comparator;
import data.Doctors;

/**
 *
 * @author ya
 */
public class SortByName implements Comparator<Doctors>{

    @Override
    public int compare(Doctors d1, Doctors d2) {
        
       String name1=d1.getName();
       String name2=d2.getName();
       return name1.compareToIgnoreCase(name2);
        
    }

}
