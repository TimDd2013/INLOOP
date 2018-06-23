public class Book {

    private String title;
    private boolean state;
    public Book(String title) {
        this.title = title;
        System.out.println("Book "+title+" created.");
    }

    public String toString() {
        return title;
    }
    /**
     * @param state the state to set
     */
    public void setState(boolean state) {
        this.state = state;
    }
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }
}
