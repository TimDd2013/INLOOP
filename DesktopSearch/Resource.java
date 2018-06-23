import java.util.*;
/**
 * Resource
 */
public class Resource {
    private String name;
    private String path;
    private ResourceType rt;
    public Resource(String name,String path,ResourceType rt){
        if (name==null||path==null||rt==null) throw new NullPointerException();
        if (name==""||path=="") throw new IllegalArgumentException();
        this.name=name;
        this.path=path;
        this.rt=rt;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;    
    }
    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }
    /**
     * @return the rt
     */
    public ResourceType getType() {
        return rt;
    }
}