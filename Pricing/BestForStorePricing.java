/**
 * BestForStorePricing
 */
public class BestForStorePricing extends ComplexPricing{
    public BestForStorePricing(ISalePricing pricing){
        super(pricing);
    }
    @Override
    public long getTotal(Sale sale) {
        long result=0;
        for (ISalePricing i:super.getPricings()){
            if (result<i.getTotal(sale)){
                result=i.getTotal(sale);
            }
        };
        return result;
    }
}