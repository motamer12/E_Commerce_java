package model.product.impl;

import model.product.BaseProduct;
import model.product.Expirable;

import java.time.LocalDate;

public class PerishableShipped extends BaseProduct implements Expirable {

    private final LocalDate expirationDate ;


    public PerishableShipped(String name, int price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate=expirationDate;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    @Override
    public boolean isAvialble(int amount){
        return amount<=quantity && !isExpired();
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}
