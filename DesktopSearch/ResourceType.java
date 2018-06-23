import java.util.*;
/**
 * ResourceType
 */
public class ResourceType {
    private String description;
    private KeywordCollector collector;
    public ResourceType(String desc,KeywordCollector collector){
        if (desc==null||collector==null) throw new NullPointerException();
        if (desc=="") throw new IllegalArgumentException();
        this.collector=collector;
        this.description=desc;
    }
    /**
     * @return the collector
     */
    public KeywordCollector getCollector() {
        return collector;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
}