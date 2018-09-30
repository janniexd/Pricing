public class PercentageDiscountPricing implements ISalePricing{
    private double percentage;

    public PercentageDiscountPricing(double percentage){
        if(percentage < 0 || percentage > 100) throw new IllegalArgumentException();
        this.percentage = percentage;
    }

    @Override
    public long getTotal(Sale sale) {
        double total = (100 - percentage) * sale.getPreDiscountTotal()/100;
        return (long) total;
    }
}
