package model.product.impl;

import model.product.BaseProduct;
import model.product.Shippable;

public class ShippedProduct extends BaseProduct implements Shippable {
    private double weight ;

    public ShippedProduct(String name, int price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    @Override
    public boolean isAvialble(int amount){
        return amount<=quantity ;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
