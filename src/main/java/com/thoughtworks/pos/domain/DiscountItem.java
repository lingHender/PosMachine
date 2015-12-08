package com.thoughtworks.pos.domain;

/**
 * Created by lilingfang on 15/12/5.
 */
public final class DiscountItem {
    private  String barcode;
    private  int discount;
   public DiscountItem(String barcode, int discount){
       this.barcode = barcode;
       this.discount = discount;
   }

    public String getBarcode() {
        return barcode;
    }

    public int getDiscount() {
        return discount;
    }
}
