/**
 * Factory
 */
public class Factory {
    private ReceivingStock stock;
    private Purchasing purchasing;
    public Factory(Purchasing purchasing,ReceivingStock receivingStock){
        if(purchasing==null || receivingStock==null) throw new NullPointerException();
        this.stock=receivingStock;
        this.purchasing=purchasing;
    }
    /**
     * @return the purchasing
     */
    public Purchasing getPurchasing() {
        return purchasing;
    }
    /**
     * @return the stock
     */
    public ReceivingStock getStock() {
        return stock;
    }
    public static Part create(PartType partType,String id,String name){
        PartType p=partType;
        Part a=new Part(id,name);
        switch(p){
            case COMPONENTS:
                a=new Components(id, name);
                break;
            case SINGLE_COMPONENT:
                a=new SingleComponent(id, name);
                break;
            case RESOURCE:
                a=new Resource(id,name);
        }
        return a;
    }
}