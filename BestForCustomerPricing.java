public class BestForCustomerPricing extends ComplexPricing{
    public BestForCustomerPricing(ISalePricing pricing){
        if(pricing == null) throw new NullPointerException();
        PricingList.add(pricing);
    }

    public long getTotal(Sale sale){
        long largest = Integer.MAX_VALUE;
        for (ISalePricing p :PricingList){
            largest = Math.min(p.getTotal(sale), largest);
        }
        return largest;
    }
}
