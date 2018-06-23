/**
 * ProjectItem
 */
public abstract class ProjectItem {
    private String name;
    private String details;
    private double rate;
    public ProjectItem(String name,String details,double rate){
        if(name==null||details==null)throw new NullPointerException();
        if(name==""||details==""||rate<0) throw new IllegalArgumentException();
        this.name=name;
        this.details=details;
        this.rate=rate;
    }
    public void setDetais(String newDetails){
        if(newDetails==null)throw new NullPointerException();
        if(newDetails=="")throw new IllegalArgumentException();
        this.details=newDetails;
    }
    public long getCostEstimate(){
        return (long)((long)(this.rate+0.5)*(long)(this.getTimeRequired()+0.5)+this.getMaterialCost());
    };
    public abstract double getTimeRequired();
    public abstract long getMaterialCost();
    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }
}