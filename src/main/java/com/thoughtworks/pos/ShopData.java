package com.thoughtworks.pos;

import java.util.Arrays;
import java.util.List;

public class ShopData {
    public static final List<String> ITEMS_DATA =
            Arrays.asList("ITEM000001:40", "ITEM000003:50", "ITEM000005:60");

    public static final List<String> SECOND_HALF_ITEMS =
            Arrays.asList("ITEM000001", "ITEM000003");

    public static final List<String> DISCOUNT_ITEMS =
            Arrays.asList("ITEM000001:75", "ITEM000005:90");
}
