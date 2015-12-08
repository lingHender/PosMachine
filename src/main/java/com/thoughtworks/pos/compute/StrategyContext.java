package com.thoughtworks.pos.compute;

import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lilingfang on 15/12/5.
 */
public class StrategyContext {
    private PromotionStrategy promotionStrategy;

    public  double  calculate(List<BillItem> billItems){
        promotionStrategy = getDiscountPromotion();
        promotionStrategy.promotionStrategy(billItems);
        promotionStrategy = getSecondHalfPromotion();
        return  promotionStrategy.promotionStrategy(billItems);
    }
    public DiscountPromotion getDiscountPromotion(){
        return new DiscountPromotion();
    }

    public SecondHalfPromotion getSecondHalfPromotion(){
        return new SecondHalfPromotion();
    }
}
