package com.thoughtworks.pos;

import com.thoughtworks.pos.compute.DiscountPromotion;
import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.parser.BillItemParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static  org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by lilingfang on 15/12/8.
 */
public class DiscountPromotionTest {
    List<BillItem> billItems;
    BillItemParser billItemParser;
    DiscountPromotion discountPromotion;

    @Before
    public void setUp(){
        billItemParser = new BillItemParser();
        discountPromotion = new DiscountPromotion();
        billItems = billItemParser.parse(Arrays.asList("ITEM000001-1", "ITEM000005-2"));
    }

    @Test
    public void should_return_sum_after_discount(){
        double sum = discountPromotion.promotionStrategy(billItems);
        assertEquals(sum,138,1e-6);
    }
}
