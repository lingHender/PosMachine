package com.thoughtworks.pos;

import com.thoughtworks.pos.compute.DiscountPromotion;
import com.thoughtworks.pos.compute.PromotionStrategy;
import com.thoughtworks.pos.compute.SecondHalfPromotion;
import com.thoughtworks.pos.compute.StrategyContext;
import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.domain.Item;
import com.thoughtworks.pos.parser.FullReduceParser;
import com.thoughtworks.pos.parser.ItemParser;
import com.thoughtworks.pos.parser.BillItemParser;

import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        List<String> billItems = asList("ITEM000001-3","ITEM000003-5","ITEM000005-3");

        PosMachine posMachine = new PosMachine(new BillItemParser(),billItems);

        System.out.println("总价:" + posMachine.calculate(new StrategyContext()));

    }
}
