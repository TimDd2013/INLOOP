import java.util.*;

/**
 * Stock
 */
public class Stock {
    private Map<Part,Integer> parts=new HashMap<Part,Integer>();
    private ArrayList<Observation> observers=new ArrayList<Observation>();
    public int get(Part part){
        if (part==null) throw new NullPointerException();
        if (!parts.containsKey(part)) return -1;
        return parts.get(part);
    }
    public boolean set(Part part,int count){
        if (part==null) throw new NullPointerException();
        if (!parts.containsKey(part)||count<0) return false;
        parts.put(part, count);
        return true;
    }
    public void insert(Part part,int count){
        if (part==null) throw new NullPointerException();
        if (count<=1) throw new IllegalArgumentException();
        if (!parts.containsKey(part)){
            parts.put(part, count);
        }else{
            parts.put(part,count+parts.get(part));
        }
    }
    public boolean delete(Part part,int count){
        if (part==null) throw new NullPointerException();
        if (!parts.containsKey(part)||count<0||parts.get(part)<count) return false;
        if (parts.get(part)==count){parts.remove(part);}
        if (parts.get(part)>count){parts.put(part,parts.get(part)-count);}
        notify(part);
        return true;
    }
    public void register(Observation observer){
        observers.add(observer);
    }
    public void notify(Part part){
        for(Observation observer:observers){
            observer.alarm(part);
        }
    }
}