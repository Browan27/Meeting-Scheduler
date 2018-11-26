package meeting.scheduler;

/**
 *
 * @author Blake
 */
public class Month {
    private Day[][] dayArray;
    private int monthIndex;
    
    public Month(int o, int n, int index) {
        dayArray = new Day[6][7];
        int offset = o;
        int numActiveDays = n;
        int currentDay = 1;
        monthIndex = index;
        
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                if(offset > 0) {
                    dayArray[i][j] = new Day();
                    offset--;
                }
                else if(currentDay <= numActiveDays) {
                    dayArray[i][j] = new Day(true, j, currentDay);
                    currentDay++;
                }
                else {
                    dayArray[i][j] = new Day();
                }
            }
        }
    }
    
    public Day getDay(int x, int y) {
        return dayArray[x][y];
    }
    
    public void addConflicts(int d, int c) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                if(dayArray[i][j].getDate() == d) dayArray[i][j].addConflicts(c);
            }
        }
    }
    
    public String toString() {
        String m = "Month: " + monthIndex + "\n";
        m += "S, M, T, W, TH, F, SA\n"
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                if(dayArray[i][j].hasConflicts()) {
                    m += dayArray[i][j].getDate() + "(" + (dayArray[i][j].getConflicts()) + "), ";
                }
                else m += dayArray[i][j].getDate() + ", ";
            }
            m += "\n";
        }
        return m;
    }
    
    public int getMonth() {
        return monthIndex;
    }
}
