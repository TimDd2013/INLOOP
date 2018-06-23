/**
 * AbstractEnterpriseUnit
 */
abstract class AbstractEnterpriseUnit implements EnterpriseNode{
    private String name;
    public AbstractEnterpriseUnit(String name){
        if (name==null) throw new NullPointerException();
        this.name=name;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}