package model.product.impl;

import model.product.BaseProduct;
import model.product.Expirable;
import model.product.Shippable;

import java.time.LocalDate;

public class PerishableProduct extends BaseProduct implements Expirable, Shippable {
    private LocalDate expirationDate;
    private double weight;

    public PerishableProduct(String name, int price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;
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

    @Override
    public double getWeight() {
        return weight;
    }
}
