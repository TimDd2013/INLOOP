import java.util.*;

/**
 * Tast
 */
public class Task extends ProjectItem{
    private List<ProjectItem> projectItems;
    public Task(String name,String details,double rate){
        super(name, details, rate);
        projectItems=new ArrayList<ProjectItem>();
    }
    @Override
    public long getMaterialCost() {
        long result=0;
        for(Deliverable de:allDeliverables()){
            result+=de.getMaterialCost();
        }
        return result;
    }
    @Override
    public double getTimeRequired() {
        double result=0;
        for(Deliverable de:allDeliverables()){
            result+=de.getTimeRequired();
        }
        return result;
    }
    public void addProjectItem(ProjectItem pi){
        if(pi==null) throw new NullPointerException();
        projectItems.add(pi);
    }
    public void removeProjectItem(ProjectItem pi){
        if(pi==null) throw new NullPointerException();
        projectItems.remove(pi);
    }
    public List<Deliverable> allDeliverables(){
        ArrayList<Deliverable> result=new ArrayList<Deliverable>();
        for(ProjectItem a: projectItems){
            if(a instanceof Deliverable){
                result.add((Deliverable)a);
            }else if(a instanceof Task){
                result.addAll(((Task)a).allDeliverables());
            }
        }
        return result;
    }
    @Override
    public long getCostEstimate() {
        long result=0;
        result=(long)(this.getRate()*getTimeRequired()+getMaterialCost()+0.5);
        return (long)result;
    }

    
}