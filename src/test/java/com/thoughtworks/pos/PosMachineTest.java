package com.thoughtworks.pos;

import org.junit.Before;
import org.junit.Test;
import static  org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;


public class PosMachineTest {
    private PosMachine posMachine;
    private List<String> billItems;

    @Before
    public void setUp() {
        posMachine = new PosMachine();
        billItems = Arrays.asList("ITEM000001-3", "ITEM000003-2","ITEM000005-3");
    }


    @Test
    public void should_calculate_total_with_promotion() {
        double total =  posMachine.calculateWithPromotion(billItems);
        assertEquals(total,312,1e-6);
    }

    @Test
    public void should_calculate_total_without_promotion() {
        double total = posMachine.calculateWithoutPromotion(billItems);

        assertEquals(total,400,1e-6);
    }
}