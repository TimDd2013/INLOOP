/**
 * Part
 */
public class Part {
    private String id;
    private String name;
    public Part(String id,String name){
        if (id==null||name==null) throw new NullPointerException();
        if (id==""||name=="") throw new IllegalArgumentException();
        this.id=id;
        this.name=name;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
}