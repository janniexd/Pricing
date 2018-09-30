public class Sale {
    private long preDiscountTotal = 0;
    private ISalePricing pricing;

    public Sale(long preDiscountTotal, ISalePricing pricing){
        if(preDiscountTotal < 0) throw new IllegalArgumentException();
        if(pricing == null) throw new NullPointerException();
        this.preDiscountTotal = preDiscountTotal;
        this.pricing = pricing;
    }

    public long getPreDiscountTotal() {
        return preDiscountTotal;
    }

    public void setPricing(ISalePricing pricing){
        if(pricing == null) throw new NullPointerException();
        this.pricing = pricing;
    }
//!!!
    public long getTotal(){
        return pricing.getTotal(this);
    }

    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount, long threshold){
        ISalePricing pricing;
        switch (discountType){
            case PERCENTAGEDISCOUNT:
                pricing = new PercentageDiscountPricing(percentage);
                return pricing;
            case ABSOLUTEDISCOUNT:
                pricing = new AbsoluteDiscountPricing(discount, threshold);
                return pricing;
        }
        return null;
    }


}
