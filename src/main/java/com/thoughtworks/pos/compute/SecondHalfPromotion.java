package com.thoughtworks.pos.compute;

import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.domain.SecondHalfItem;

import java.util.List;

/**
 * Created by lilingfang on 15/12/8.
 */
public class SecondHalfPromotion implements PromotionStrategy{
    @Override
    public double promotionStrategy(List<BillItem> billItems) {
        double sum = 0.0;
        for (BillItem billItem : billItems) {
            double billItemSum = billItem.getPrice()*billItem.getQuantity();
            for (SecondHalfItem secondHalfItem : BasicData.secondHalfItems) {
                if (billItem.getBarcode().equals(secondHalfItem.getBarcode())) {
                   double f =billItem.getPrice() / 2 * (billItem.getQuantity() / 2);
                    billItemSum -= f;
                }
            }
            sum += billItemSum;
        }
        return sum;
    }
}
