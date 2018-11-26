package meeting.scheduler;

/**
 *
 * @author Blake
 */
import java.util.*;

public class Year {
    private int yearIndex;
    private boolean leapYear;
    private Month[] monthArray;
    
    public Year(int y) {
        yearIndex = y;
        setLeap();
        monthArray = new Month[12];
        
        Calendar calendar = Calendar.getInstance();
        
        boolean flip = true;
        for(int i = 0; i < 12; i++) {
            calendar.set(yearIndex, i, 0);
            
            if(i == 1) {
                if(leapYear) monthArray[i] = new Month(calendar.get(Calendar.DAY_OF_WEEK), 29, i);
                else monthArray[i] = new Month(calendar.get(Calendar.DAY_OF_WEEK), 28, i);
                flip = !flip;
            }
            else if(flip) {
                monthArray[i] = new Month(calendar.get(Calendar.DAY_OF_WEEK), 31, i);
                flip = !flip;
            }
            else {
                monthArray[i] = new Month(calendar.get(Calendar.DAY_OF_WEEK), 30, i);
                flip = !flip;
            }
            
            if(i == 6) flip = !flip;
        }
    }
    
    private void setLeap() {
        if(yearIndex % 4 == 0)
        {
            if(yearIndex % 100 == 0)
            {
                // year is divisible by 400, hence the year is a leap year
                if(yearIndex % 400 == 0) leapYear = true;
                else leapYear = false;
            }
            else leapYear = true;
        }
        else leapYear = false;
    }
    
    public Month getMonth(int i) {
        return monthArray[i];
    }
    
    public void addConflicts(int m, int d, int c) {
        monthArray[m].addConflicts(d, c);
    }
    
    public String toString() {
        String y = "Year: " + yearIndex + "\n\n";
        for(int i = 0; i < 12; i++) {
            y += monthArray[i].toString();
            y += "\n";
        }
        return y;
    }
}
