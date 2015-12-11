package com.thoughtworks.pos.compute;

import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.domain.FullReduceItem;

import java.util.List;

/**
 * Created by lilingfang on 15/12/11.
 */
public class FullReducePromotion implements PromotionStrategy {
    @Override
    public double promotionStrategy(List<BillItem> billItems) {
        double sum = 0.0;
        for(BillItem item : billItems){
            for(FullReduceItem fullReduceItem : BasicData.fullReduceItems)
                if(item.getBarcode().equals(fullReduceItem.getBarcode())&&item.getTotalPrice()>=fullReduceItem.getFullPrice()){
                    item.setTotalPrice(item.getTotalPrice()-fullReduceItem.getReducePrice());
                }
              sum += item.getTotalPrice();
        }
        return sum;
    }
}
