import java.util.Observable;

/**
 * Time
 */
public class Time extends Observable {
    private static Time instance= new Time();
    private int currentTime = 0;
    private int endOfTime = 100;

    /**
     * @return the instance
     */
    public static Time getInstance() {
        return instance;
    }

    private Time() {
        super();
    }

    /**
     * @return the currentTime
     */
    public int getCurrentTime() {
        return currentTime;
    }

    public void initEndOfTime(int seconds) {
        if (seconds <= 0)
            throw new IllegalArgumentException();
        this.currentTime = 0;
        this.endOfTime = seconds;
    }

    public void run() {
        while (currentTime < endOfTime) {
            currentTime += 1;
            synchronized (getInstance()) {
                this.setChanged();
                this.notifyObservers(getCurrentTime());;
            }
        }
    }
}