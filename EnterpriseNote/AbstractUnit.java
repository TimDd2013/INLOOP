/**
 * AbstractUnit
 */
import java.util.*;
public abstract class AbstractUnit extends AbstractEnterpriseUnit {
    protected List<AbstractEnterpriseUnit> childNodes;
    public AbstractUnit(String name){
        super(name);
        childNodes=new ArrayList<AbstractEnterpriseUnit>();
    }
    public boolean add(AbstractEnterpriseUnit childNode){
        if (childNode==null) throw new NullPointerException();
        if (childNodes.contains(childNode)) return false;
        return childNodes.add(childNode);
    }
    public boolean remove(AbstractEnterpriseUnit childNode){
        return childNodes.remove(childNode);
    }
    /**
     * @return the childNodes
     */
    public List<AbstractEnterpriseUnit> getChildNodes() {
        return childNodes;
    }
    
}