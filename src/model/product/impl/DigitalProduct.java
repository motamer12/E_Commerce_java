package model.product.impl;

import model.product.BaseProduct;

public class DigitalProduct extends BaseProduct {

    public DigitalProduct(String name, int price, int quantity) {
        super(name, price, quantity);
    }
    @Override
    public boolean isAvialble(int amount){
        return amount<=quantity ;
    }
}
