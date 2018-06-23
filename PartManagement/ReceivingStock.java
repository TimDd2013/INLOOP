/**
 * ReceivingStock
 */
public class ReceivingStock extends Stock{
    private int minStockItems;
    private int maxStockItems;
    public ReceivingStock(int minStockItems,int maxStockItems){
        if (minStockItems<1||maxStockItems<minStockItems) throw new IllegalArgumentException();
        this.minStockItems=minStockItems;
        this.maxStockItems=maxStockItems;
    }
    /**
     * @return the minStockItems
     */
    public int getMinStockItems() {
        return minStockItems;
    }
    /**
     * @return the maxStockItems
     */
    public int getMaxStockItems() {
        return maxStockItems;
    }
}