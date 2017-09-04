

package sort;

import java.util.Comparator;
import java.util.Date;
import data.Doctors;

/**
 *
 * @author ya
 */
public class SortByDate implements Comparator<Doctors>{

    @Override
    public int compare(Doctors d1, Doctors d2) {
        
        Date date1=d1.getDateOfBirth();
        Date date2=d2.getDateOfBirth();
        return date1.compareTo(date2);
    }

}
