/**
 * ComplexPricing
 */
import java.util.*;
public abstract class ComplexPricing implements ISalePricing{
    private List<ISalePricing> pricings;
    public ComplexPricing(ISalePricing pricing){
        if (pricing==null) throw new NullPointerException();
        pricings=new ArrayList<ISalePricing>();
        pricings.add(pricing);
    }
    public void add(ISalePricing pricing){
        pricings.add(pricing);
    }
    @Override
    public long getTotal(Sale sale) {
        return getPricings().get(0).getTotal(sale);
    }
    /**
     * @return the pricings
     */
    public List<ISalePricing> getPricings() {
        return pricings;
    }
}