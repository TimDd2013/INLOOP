import java.util.*;

/**
 * Team
 */
public class Team extends AbstractEnterpriseUnit{
    private StaffMember teamLeader;
    public Team(String name,StaffMember teamLeader){
        super(name);
        if (name==null) throw new NullPointerException();
        if (name=="") throw new IllegalArgumentException();
        if (teamLeader==null) throw new NullPointerException();
        this.teamLeader=teamLeader;
    }
    /**
     * @return the teamLeader
     */
    public StaffMember getTeamLeader() {
        return teamLeader;
    }
    public List<StaffMember> getTeamMembers(){
        //to do...
        List<StaffMember> result=new ArrayList<StaffMember>();
        TreeSet<StaffMember> le=new TreeSet<StaffMember>();
        le.add(teamLeader);
        StaffMemberIterator mem=new StaffMemberIterator(le);
        while(mem.hasNext()){
            result.add(mem.next());
        }
        return result;
    }
}