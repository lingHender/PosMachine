package com.thoughtworks.pos.compute;

import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.domain.DiscountItem;

import java.util.List;

/**
 * Created by lilingfang on 15/12/6.
 */
public class DiscountPromotion implements PromotionStrategy {
    @Override
    public double promotionStrategy(List<BillItem> billItems) {
        double sum = 0.0;
        for (BillItem billItem : billItems) {
            for (DiscountItem discountItem : BasicData.discountItems) {
                if (billItem.getBarcode().equals(discountItem.getBarcode()))
                    billItem.setPrice(billItem.getPrice() * discountItem.getDiscount() / 100);
            }
            sum += billItem.getPrice() * billItem.getQuantity();
        }
        return sum;
    }
}
