/**
 * StaffMemberIterator
 */
import java.util.*;
public class StaffMemberIterator implements EnterpriseNodeIterator<StaffMember>{
    private Set<StaffMember> allMembers;
    public StaffMemberIterator(Set<StaffMember> directSubordinates){
        allMembers=new TreeSet<StaffMember>();
        for (StaffMember a:directSubordinates){
            findSubordinateRecursively(a);
        }
    }
    private void findSubordinateRecursively(StaffMember m){
        allMembers.add(m);
        if(m.getDirectSubordinates()!=null){
            for (StaffMember a:m.getDirectSubordinates()){
                findSubordinateRecursively(a);
            }
        }
    }
    @Override
    public boolean hasNext() {
        Iterator<StaffMember> it=allMembers.iterator();
        return it.hasNext();
    }
    @Override
    public StaffMember next() {
        Iterator<StaffMember> it=allMembers.iterator();
        StaffMember a =it.next();    
        allMembers.remove(a);
        return a;
    }
}