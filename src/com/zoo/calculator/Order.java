package com.zoo.calculator;

import com.zoo.vo.ItemVO;
import com.zoo.vo.Menu;

import java.util.*;

public class Order {

    private List<ItemVO> orderItems;
    private double totalOrder;
    private double totalPromo;
    private double totalBill;

    public Order(){
        this.orderItems = new ArrayList<>();
    }

    public void addToOrderList(Menu item, int qty){
        this.orderItems.add(new ItemVO(item, qty));
    }

    public List<ItemVO> getOrderItems() {
        return orderItems;
    }

    public double getTotalOrder() {
        return totalOrder;
    }

    public double getTotalPromo() {
        return totalPromo;
    }

    public double getTotalBill() {
        return totalBill;
    }

    /*
    * Calculator to determine the totals with promo consideration
    * Logic: Buy 2 Get 1 Free
    * Min quantity for discount = 3
    * Discount Multiplier = multiples of 3 in the order qty
    * Net discount = unit price x discount multiplier x free qty offered
    */
    public void calculateTotalOrder(){
        if(this.orderItems.size() <= 0){
            this.totalOrder = 0;
            this.totalPromo = 0;
        }else{
            this.totalOrder = this.orderItems.stream().mapToDouble(item -> (item.getQty() * item.getItem().getUnitPrice())).sum();
            this.totalPromo = this.orderItems.stream().mapToDouble(order -> {
                if(!Objects.equals(order.getItem().getPromo(), null)){
                    int qty = order.getQty();
                    int minQtyForDiscount = order.getItem().getPromo().getOfferBuyQty() + order.getItem().getPromo().getOfferGetQty();
                    int discountMultiplier = qty/minQtyForDiscount;
                    if(discountMultiplier >= 1){
                        return order.getItem().getUnitPrice() * discountMultiplier * order.getItem().getPromo().getFreeQty();
                    }else {
                        return 0;
                    }
                }else{
                    return 0;
                }
            }).sum();
        }
        this.totalPromo *= this.totalPromo > 0 ? -1 : 0;
        this.totalBill = this.totalOrder + this.totalPromo;
    }


}
