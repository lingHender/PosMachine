package com.thoughtworks.pos;

import com.thoughtworks.pos.compute.DiscountPromotion;
import com.thoughtworks.pos.compute.SecondHalfPromotion;
import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.parser.BillItemParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lilingfang on 15/12/8.
 */
public class SecondHalfPromotionTest {
    private SecondHalfPromotion secondHalfPromotion;
    List<BillItem> billItems;
    BillItemParser billItemParser;

    @Before
    public void setUp(){
        billItemParser = new BillItemParser();
        secondHalfPromotion = new SecondHalfPromotion();
        billItems = billItemParser.parse(Arrays.asList("ITEM000001-2", "ITEM000003-2"));
    }
    @Test
    public void should_return_sum_after_discount(){
        double sum = secondHalfPromotion.promotionStrategy(billItems);
        assertEquals(sum,135,1e-6);
    }
}
