/**
 * StaffMember
 */
import java.util.*;
public class StaffMember implements EnterpriseNode, Comparable<StaffMember>{
    private String name;
    private String job;
    private Set<StaffMember> directSubordinates;
    public StaffMember(String name,String job){
        if(name==null||job==null) throw new NullPointerException();
        if(name==""||job=="") throw new IllegalArgumentException();
        this.name=name;
        this.job=job;
        directSubordinates =new TreeSet<StaffMember>();
    }
    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }
    public boolean addDirectSubordinate(StaffMember subordinate){
        if(subordinate == null) throw new NullPointerException();
        if (directSubordinates.contains(subordinate)) return false;
        return directSubordinates.add(subordinate);
    }
    public boolean removeDirectSubordinate(StaffMember subordinate){
        return directSubordinates.remove(subordinate);
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int compareTo(StaffMember o) {
        return this.name.compareTo(o.name);
    }
    /**
     * @return the directSubordinates
     */
    public Set<StaffMember> getDirectSubordinates() {
        return directSubordinates;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}