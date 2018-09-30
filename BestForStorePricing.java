public class BestForStorePricing extends ComplexPricing {
    public BestForStorePricing(ISalePricing pricing){
        if(pricing == null) throw new NullPointerException();
        PricingList.add(pricing);
    }

    public long getTotal(Sale sale){
        long lowest = 0;
        for(ISalePricing p : PricingList){
            lowest = Math.max(p.getTotal(sale), lowest);
        }
        return lowest;
    }
}
