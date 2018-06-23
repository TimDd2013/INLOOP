/**
 * Time
 */
public class Time {
    private int hour;
    private int minute;
    public Time(int hour,int minute){
        if (hour<0||hour>23||minute<0||minute>59) throw new IllegalArgumentException();
        this.hour=hour;
        this.minute=minute;
    }
    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }
    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }
}