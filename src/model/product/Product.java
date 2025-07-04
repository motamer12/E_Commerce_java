package model.product;

public interface Product {
    String getName();
    int getPrice();
    int getQuantity();
    void reduceQuantity(int amount);
    boolean isAvialble(int amount);
}
