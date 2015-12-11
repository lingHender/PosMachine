package com.thoughtworks.pos;

import com.thoughtworks.pos.parser.FullReduceParser;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

/**
 * Created by lilingfang on 15/12/11.
 */
public class FullReduceItemTest {
    private FullReduceParser parser;

    @Before
    public  void setUp(){
      parser = new FullReduceParser();
    }

    @Test
    public void should_get_empty_goods_given_none() {
        List<FullReduceItemTest>  items = parser.parse(Arrays.<>asList());
        List<FullReduceItemTest> expectedItems = asList();
        Assert.assertThat(items, Is.is(expectedItems));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_complain_invalid_input() {
        parser.parse(asList("blabla:80:90"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_complain_invalid_price() {
        parser.parse(asList("blabla:d8"));
    }

    @Test
    public void should_get_1_good() {
        List<FullReduceItemTest> items = parser.parse(asList("ITEM000001:100-20"));
        Assert.assertThat(items.get(0).getBarcode(), Is.is("ITEM000001"));
        assertEquals(items.get(0).getDiscount(),75);
    }

    @Test
    public void should_get_more_goods() {
        List<DiscountItem> items = parser.parse(asList("ITEM000001:75", "ITEM000002:90"));
        Assert.assertThat(items.get(0).getBarcode(), Is.is("ITEM000001"));
        Assert.assertThat(items.get(1).getBarcode(), Is.is("ITEM000002"));
        assertEquals(items.get(0).getDiscount(), 75);
        assertEquals(items.get(1).getDiscount(), 90);
    }
}
