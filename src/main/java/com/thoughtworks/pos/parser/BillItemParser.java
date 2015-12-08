package com.thoughtworks.pos.parser;

import com.thoughtworks.pos.ShopData;
import com.thoughtworks.pos.compute.BasicData;
import com.thoughtworks.pos.domain.BillItem;
import com.thoughtworks.pos.domain.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class BillItemParser extends Parser<BillItem> {
    private static final Pattern PATTERN = compile("^(\\w+)-(\\d+)$");

    public List<String> transformString(List<String> billItems){
        List<String> correctBillItems = new ArrayList<String>();
        for(String line : billItems){
            if(line.indexOf("-") == -1){
                line = new StringBuilder().append(line).append("-1").toString();
            }
            correctBillItems.add(line);
        }
        return correctBillItems;
    }

    @Override
    protected BillItem parseLine(final String line) {
        String[] splitLine = line.split("-");
        String barcode = splitLine[0];
        int quantity = Integer.parseInt(splitLine[1]);
        for(Item item : BasicData.items){
            if(barcode.equals(item.getBarcode())) {
                return new BillItem(barcode,quantity,item.getPrice());
            }
        }
        throw new IllegalArgumentException("can't find in all items");
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}
