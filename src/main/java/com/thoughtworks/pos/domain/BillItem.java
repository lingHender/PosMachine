package com.thoughtworks.pos.domain;

public final class BillItem {
    private final String barcode;
    private final Integer quantity;
    private double price;

    public BillItem(final String barcode, final Integer quantity, double price) {
        this.barcode = barcode;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
