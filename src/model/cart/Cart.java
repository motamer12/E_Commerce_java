package model.cart;

import model.product.Product;
import model.product.Shippable;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> Cart;

    public Cart (){
        this.Cart=new HashMap<>();
    }

    public void addItem(Product product,int quantity){
        if(checkItemExist(product)){
            availabilty(product,quantity);
            updateQuantity(product,quantity);
        }
        Cart.put(product,quantity);

    }

    public void updateQuantity(Product product ,int quantity){
        int newQuantity = quantity +Cart.get(product);
        Cart.put(product, newQuantity);
    }

    public void availabilty(Product product,int quantity){
        if (!product.isAvialble(quantity)) {
            throw new IllegalArgumentException("Quantity is not available in stock.");
        }
    }
    public boolean checkItemExist(Product product ){
        return Cart.containsKey(product);
    }

    public Map<Product, Integer> getCart() {
        return Cart;
    }

    public boolean isEmpty() {
        return Cart.isEmpty();
    }
    public double calcSubTotal (){
        double subTotal=0.0;
        for (Product product :Cart.keySet()){
            int quantity = Cart.get(product);
            subTotal += product.getPrice() * quantity;
        }
        return subTotal;
    }
    public Map<Shippable,Integer> getShippedItem(){
        Map<Shippable,Integer> shipped=new HashMap<>();
        for (Product product:Cart.keySet()){
            if (product instanceof Shippable){
                int quantity =Cart.get(product);
                shipped.put((Shippable) product,quantity);
            }
        }
        return shipped;
    }
}
