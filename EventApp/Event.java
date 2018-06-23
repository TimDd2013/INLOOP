/**
 * Event
 */
public class Event implements Comparable<Event>{
    private EventCategory category;
    private String title;
    public Event(String title,EventCategory category){
        if (title==null||category==null) throw new NullPointerException();
        if (title=="") throw new IllegalArgumentException();
        this.title=title;
        this.category=category;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @return the category
     */
    public EventCategory getCategory() {
        return category;
    }
    @Override
    public int compareTo(Event o) {
        if(this.title.compareTo(o.title)==0){
            return this.category.compareTo(o.category);
        }
        return this.title.compareTo(o.title);
    }
    
}