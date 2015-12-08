package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.parser.BillItemParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BillItemParserTest {
    private BillItemParser parser;

    @Before
    public void setUp() {
        parser = new BillItemParser();
    }

    @Test
    public void should_get_empty_when_given_none() {
        List<BillItem> billItems = parser.parse(Arrays.<String>asList());
        List<BillItem> expectBillItems = Arrays.<BillItem>asList();
        assertThat(billItems, is(expectBillItems));
    }

    @Test
    public void should_get_1_bill_item() {
        List<BillItem> billItems = parser.parse(Arrays.asList("ITEM000001-2"));

        assertThat(billItems.size(), is(1));
        assertThat(billItems.get(0).getBarcode(), is("ITEM000001"));
        assertThat(billItems.get(0).getQuantity(), is(2));
        assertEquals(billItems.get(0).getPrice(),40,1e-6);
    }

    @Test
    public void should_get_more_bill_item() {
        List<BillItem> billItems = parser.parse(Arrays.asList("ITEM000001-1", "ITEM000003-2"));
        assertThat(billItems.size(), is(2));
        assertThat(billItems.get(0).getBarcode(), is("ITEM000001"));
        assertThat(billItems.get(0).getQuantity(), is(1));
        assertEquals(billItems.get(0).getPrice(), 40, 1e-6);
        assertThat(billItems.get(1).getBarcode(), is("ITEM000003"));
        assertThat(billItems.get(1).getQuantity(), is(2));
        assertEquals(billItems.get(1).getPrice(), 50, 1e-6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_complain_can_not_find_item() {
        parser.parse(Arrays.<String>asList("ITEM000009-3"));
    }

    @Test
    public void should_return_correct_String_with_input_wrong(){
        List<String> billItems = parser.transformString(Arrays.asList("ITEM000001"));
        assertThat(billItems.size(),is(1));
        assertThat(billItems.get(0),is("ITEM000001-1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_complain_invalid_amount() {
        parser.parse(Arrays.<String>asList("T1-2b"));
    }
}
