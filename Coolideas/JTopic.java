/**
 * JTopic
 */
public class JTopic extends JContent{
    private int id;
    public JTopic(String title,String description,int id){
        super(title, description);
        if (id<=0) throw new IllegalArgumentException();
        this.id=id;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Topic: "+this.getTitle()+"\n"+this.getDescription();
    }
    @Override
    public void setTitle(String title) {
        setChanged();
        super.setTitle(title);
        notifyObservers(this.id);
    }
    /**
     * @param id the id to set
     */
    @Override
    public void setDescription(String description) {
        setChanged();
        super.setDescription(description);
        notifyObservers(this.id);
    }
}