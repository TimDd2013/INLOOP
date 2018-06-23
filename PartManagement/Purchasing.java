/**
 * Purchasing
 */
public class Purchasing implements Observation{
    private ReceivingStock stock;
    public Purchasing(ReceivingStock receivingStock){
        if (receivingStock==null) throw new NullPointerException();
        this.stock=receivingStock;
    }
    public void buy(Part part,int count){
        if (part==null) throw new NullPointerException();
        if (count<=0) throw new IllegalArgumentException();
        stock.insert(part, count);
    }
    /**
     * @return the stock
     */
    public ReceivingStock getStock() {
        return stock;
    }
    @Override
    public void alarm(Part part) {
        if(stock.get(part)<stock.getMinStockItems()){
            stock.set(part, stock.getMaxStockItems());
        }
    }
}