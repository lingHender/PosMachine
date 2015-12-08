package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.Item;
import com.thoughtworks.pos.domain.SecondHalfItem;
import com.thoughtworks.pos.parser.SecondHalfItemParse;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by lilingfang on 15/12/8.
 */
public class SecondHalfItemTest {
    private SecondHalfItemParse parser;

    @Before
    public void setUp(){
        parser = new SecondHalfItemParse();
    }
    @Test
    public void should_get_empty_goods_given_none() {
        List<SecondHalfItem> items = parser.parse(Arrays.<String>asList());
        List<SecondHalfItem> expectedItems = asList();
        assertThat(items, is(expectedItems));
    }

    @Test
    public void should_get_1_good() {
        List<SecondHalfItem> items = parser.parse(asList("Item0001"));
        assertThat(items.get(0).getBarcode(), is("Item0001"));
    }

    @Test
    public void should_get_2_goods() {
        List<SecondHalfItem> items = parser.parse(asList("Item0001", "Item0002"));
        assertThat(items.get(0).getBarcode(), is("Item0001"));
        assertThat(items.get(1).getBarcode(), is("Item0002"));
    }
}