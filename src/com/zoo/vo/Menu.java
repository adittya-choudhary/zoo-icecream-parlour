package com.zoo.vo;

public class Menu {

    private String itemName;
    //this is kept as a string because it could be in any denomination. As per spec it's ZDR
    private double unitPrice;
    private Promotion promo;

    public Menu(){}

    public Menu(String itemName, double unitPrice, String promo) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.promo = (promo != null && !promo.isEmpty()) ? new Promotion(promo) : null;
    }

    public String getItemName() {
        return itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Promotion getPromo() {
        return promo;
    }

}
