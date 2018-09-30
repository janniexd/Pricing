import java.util.ArrayList;
import java.util.List;

public abstract class ComplexPricing implements ISalePricing{
    List<ISalePricing> PricingList = new ArrayList<>();
    public void add(ISalePricing pricing){
        PricingList.add(pricing);
    }

    public List<ISalePricing> getPricings(){
        return PricingList;
    }
}
