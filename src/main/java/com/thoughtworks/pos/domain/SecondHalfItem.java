package com.thoughtworks.pos.domain;

/**
 * Created by lilingfang on 15/12/8.
 */
public final class SecondHalfItem {

    private final String barcode;

    public SecondHalfItem(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

}
