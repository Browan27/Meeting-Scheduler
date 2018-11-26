package meeting.scheduler;

/**
 *
 * @author Blake
 */

import java.text.SimpleDateFormat;
import java.util.*;
        
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Year thisYear = new Year(2019);
        thisYear.addConflicts(0, 12, 5);
        System.out.println(thisYear.toString());
    }
}
