package com.thoughtworks.pos.parser;

import com.thoughtworks.pos.domain.DiscountItem;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * Created by lilingfang on 15/12/5.
 */
public class DiscountItemParser extends Parser<DiscountItem>{
    private static final Pattern PATTERN = compile("^(\\w+):(\\d+)$");

    @Override
    protected DiscountItem parseLine(String line) {
        String barcode = line.split(":")[0];
        int price = Integer.parseInt(line.split(":")[1]);
        return new DiscountItem(barcode, price);
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}
