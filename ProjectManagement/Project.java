import java.util.*;

/**
 * Project
 */
public class Project {
    private String name;
    private String description;
    private Task mainTask;
    public Project(String name,String description,double rate){
        if (name==null||description==null) throw new NullPointerException();
        if (rate<=0||name==""||description=="") throw new IllegalArgumentException();
        this.name=name;
        this.description=description;
        this.mainTask=new Task(name,description,rate);
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    public void setTask(Task newTask){
        if(newTask==null) throw new NullPointerException();
        this.mainTask=newTask;
    }
    public double getDuration(){
        return this.mainTask.getTimeRequired();
    }
    public long getTotalCost(){
        return this.mainTask.getCostEstimate();
    }
    public Map<Calendar,List<Deliverable>> allDeliverables(){
        Map<Calendar,List<Deliverable>> result=new HashMap<Calendar,List<Deliverable>>();
        for (Deliverable de:this.mainTask.allDeliverables()){
            if(!result.containsKey(de.getDate())){
                List<Deliverable> li=new ArrayList<Deliverable>();
                li.add(de);
                result.put(de.getDate(),li);
            }else{
                result.get(de.getDate()).add(de);
            }
        }
        return result;
    }
}