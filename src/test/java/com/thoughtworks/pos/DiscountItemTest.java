package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;
import com.thoughtworks.pos.compute.StrategyContext;
import com.thoughtworks.pos.parser.DiscountItemParser;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by lilingfang on 15/12/5.
 */
public class DiscountItemTest {
    private DiscountItemParser parser;

    @Before
    public void setUp() {
        parser = new DiscountItemParser();
    }

    @Test
    public void should_get_empty_goods_given_none() {
        List<DiscountItem> items = parser.parse(Arrays.<String>asList());
        List<DiscountItem> expectedItems = asList();
        Assert.assertThat(items, Is.is(expectedItems));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_complain_invalid_input() {
        parser.parse(asList("blabla"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_complain_invalid_price() {
        parser.parse(asList("blabla:d8"));
    }

    @Test
    public void should_get_1_good() {
        List<DiscountItem> items = parser.parse(asList("ITEM000001:75"));
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
