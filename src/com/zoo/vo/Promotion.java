package com.zoo.vo;

public class Promotion {

    private String promo;
    private int offerBuyQty;
    private int offerGetQty;
    private double freeQty;

    public Promotion(){}

    public Promotion(String promo) {
        this.promo = promo;
        this.parsePromo(promo);
    }

    public String getPromo() {
        return promo;
    }

    public int getOfferBuyQty() {
        return offerBuyQty;
    }

    public int getOfferGetQty() {
        return offerGetQty;
    }

    public double getFreeQty() {
        return freeQty;
    }

    private void parsePromo(String promo){
        //translate "half" to it's number equivalent, empty all the alphabets
        promo = promo.replaceAll("(?i)half|halves", "0.5").replaceAll("[a-zA-Z]", "").trim();

        // Replace all the consecutive white spaces with a single space
        promo = promo.replaceAll(" +", " ");

        String[] numArr = promo.split(" ");
        if(numArr.length > 1){
            this.offerBuyQty = Integer.parseInt(numArr[0]);
            this.offerGetQty = Integer.parseInt(numArr[1]);
            this.freeQty = Double.parseDouble(numArr[numArr.length - 1]);
            if(numArr.length > 2){
                this.freeQty *= Double.parseDouble(numArr[1]);
            }
        }else {
            this.offerBuyQty = Integer.parseInt(numArr[0]);
            this.offerGetQty = 0;
            this.freeQty = 0.0;
        }
    }
}
