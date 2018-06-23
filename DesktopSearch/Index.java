import java.util.*;
/**
 * Index
 */
public class Index {
    private Map<String,List<Resource>> index;
    public Index(){
        index =new HashMap<String,List<Resource>>();
    }
    public void add(Resource res){
        /*
        if(index.get(res.getName())==null){
            List<Resource> list=new ArrayList<Resource>();
            list.add(res);
            index.put(res.getName(),list);
        }else{
            index.get(res.getName()).add(res);
        }
        */

        Iterator<String> it=res.getType().getCollector().getKeywords(res).iterator();
        while(it.hasNext()){
            String key=it.next().toString();
            //it=it.next();
            if(index.get(key)==null){
                List<Resource> list=new ArrayList<Resource>();
                list.add(res);
                index.put(key,list);
            }else{
                index.get(key).add(res);
            }
        }
         
    }
    public List<Resource> getResources(String keyword){
        if (keyword==null) throw new NullPointerException();
        if (index.containsKey(keyword)) return index.get(keyword);
        else return new ArrayList<Resource>();
    }
}