/**
 * BestForCustomerPrising
 */
public class BestForCustomerPricing extends ComplexPricing{
    public BestForCustomerPricing(ISalePricing pricing){
        super(pricing);
    }
    public long getTotal(Sale sale) {
        long result=super.getPricings().get(0).getTotal(sale);
        for (ISalePricing i:super.getPricings()){
            if (result>i.getTotal(sale)){
                result=i.getTotal(sale);
            }
        };
        return result;
    }
}