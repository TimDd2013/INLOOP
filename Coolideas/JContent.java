import java.util.Observable;

/**
 * JContent
 */
public abstract class JContent extends Observable{
    protected String title;
    protected String description;
    public JContent(String title,String description){
        if (title==null||description==null) throw new NullPointerException();
        if (title==""||description=="") throw new IllegalArgumentException();
        this.title=title;
        this.description=description;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        if (description==null) throw new NullPointerException();
        if (description=="") throw new IllegalArgumentException();
        this.description = description;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        if (title==null) throw new NullPointerException();
        if (title=="") throw new IllegalArgumentException();
        this.title = title;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}