package com.zoo.vo;

/*
* This class represents the ice cream menu item with order quantity
* */
public class ItemVO {

    //item is basically an ice cream.
    private Menu item;
    private int qty;

    public ItemVO(){}

    public ItemVO(Menu item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    public Menu getItem() {
        return item;
    }

    public void setItem(Menu item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
