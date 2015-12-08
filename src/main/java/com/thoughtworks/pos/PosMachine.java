package com.thoughtworks.pos;

import com.thoughtworks.pos.compute.StrategyContext;
import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.parser.BillItemParser;

import java.util.Iterator;
import java.util.List;

public final class PosMachine {

    private BillItemParser billItemParser;

    public PosMachine() {
        billItemParser = new BillItemParser();
    }

    public List<BillItem> getCorrectBillItem(List<String> billItems) {
        List<String> correctBillString = billItemParser.transformString(billItems);
        return billItemParser.parse(correctBillString);
    }

    public double calculateWithPromotion(List<String> billString) {
           StrategyContext strategyContext = new StrategyContext();
           List<BillItem> billItems = getCorrectBillItem(billString);
          return strategyContext.calculate(billItems);
    }


    public double calculateWithoutPromotion(List<String> billString) {
        double sum = 0.0;
        List<BillItem> billItems = getCorrectBillItem(billString);
        Iterator<BillItem> iterator = billItems.iterator();
        while (iterator.hasNext()) {
            BillItem billItem = iterator.next();
            sum += billItem.getPrice() * billItem.getQuantity();
        }
        return sum;
    }
}
