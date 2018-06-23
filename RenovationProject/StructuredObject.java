import java.util.*;

/**
 * StructuredObject
 */
public class StructuredObject extends RenovationObject{
    private Set<RenovationObject> parts;
    public StructuredObject(){
        parts=new HashSet<RenovationObject>();
    }
    @Override
    public double getPrice() {
        double result=0;
        for(RenovationObject re:parts){
            result+=re.getPrice();
        }
        return result;
    }
    @Override
    public Map<String, Integer> addMaterialReq(Map<String, Integer> materials) {
        if (materials==null) throw new NullPointerException();            
        for(String s:materials.keySet()){
            if (s==null) throw new NullPointerException();
        }
        for(Integer i:materials.values()){
            if (i==null) throw new NullPointerException();
        }
        Map<String, Integer> result=new TreeMap<String, Integer>();
        for(RenovationObject re:parts){
            result=re.addMaterialReq(result);
        }
        return result;
    }
    public void add(RenovationObject r){
        if(r==null) throw new NullPointerException();
        parts.add(r);
    }
    
}