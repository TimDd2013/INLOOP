/**
 * Sale
 */
public class Sale {
    private ISalePricing pricing;
    private long preDiscountTotal;
    public Sale(long preDiscountTotal,ISalePricing pricing){
        if (preDiscountTotal<0) throw new IllegalArgumentException();
        if (pricing==null) throw new NullPointerException();
        this.preDiscountTotal=preDiscountTotal;
        this.pricing=pricing;
    }
    /**
     * @return the preDiscountTotal
     */
    public long getPreDiscountTotal() {
        return preDiscountTotal;
    }
    /**
     * @return the pricing
     */
    public ISalePricing getPricing() {
        return pricing;
    }
    public long getTotal(){
        return pricing.getTotal(this);
    }
    public static ISalePricing createPricing(DiscountType discountType,double percentage,long discount,long threshold){
        if(discountType==null) throw new NullPointerException();
        if (discountType==DiscountType.PERCENTAGEDISCOUNT){
            return new PercentageDiscountPricing(percentage);
        }
        if (discountType==DiscountType.ABSOLUTEDISCOUNT){
            return new AbsoluteDiscountPricing(discount, threshold);
        }
        return null;
    }
    public void setPricing(ISalePricing pricing){
        if(pricing==null) throw new NullPointerException();
        this.pricing=pricing;
    }
}