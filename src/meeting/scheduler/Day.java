package meeting.scheduler;

/**
 *
 * @author Blake
 */
public class Day {
    private int dayIndex;
    private int date;
    private int conflicts;
    private boolean status;
    
    public Day() {
        status = false;
        dayIndex = 0;
        date = 0;
        conflicts = -1;
    }
    
    public Day(boolean s, int indexInt, int dateInt) {
        status = s;
        dayIndex = indexInt;
        date = dateInt;
        conflicts = 0;
    }
    
    public void addConflicts(int c) {
        conflicts += c;
    }
    
    public int getDay() {
        return dayIndex;
    }
    
    public int getDate() {
        return date;
    }
    
    public int getConflicts() {
        return conflicts;
    }
    
    public boolean hasConflicts() {
        if(conflicts > 0) return true;
        else return false;
    }
}
