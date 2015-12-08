package com.thoughtworks.pos.compute;

import com.thoughtworks.pos.ShopData;
import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;
import com.thoughtworks.pos.domain.SecondHalfItem;
import com.thoughtworks.pos.parser.DiscountItemParser;
import com.thoughtworks.pos.parser.ItemParser;
import com.thoughtworks.pos.parser.SecondHalfItemParse;

import java.util.List;

/**
 * Created by lilingfang on 15/12/8.
 */
public class BasicData {
    public static final List<Item> items = new ItemParser().parse(ShopData.ITEMS_DATA);
    public static final List<DiscountItem> discountItems = new DiscountItemParser().parse(ShopData.DISCOUNT_ITEMS);
    public static final List<SecondHalfItem> secondHalfItems = new SecondHalfItemParse().parse(ShopData.SECOND_HALF_ITEMS);
}
