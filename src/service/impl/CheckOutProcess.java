package service.impl;

import model.cart.Cart;
import model.cutomer.Customer;
import model.product.Product;
import service.CheckOutService;
import service.ShippingService;

public class CheckOutProcess implements CheckOutService {
    private final ShippingService shippingService;

    public CheckOutProcess(ShippingService shippingService) {
        this.shippingService = shippingService;
    }


    @Override
    public void checkOut(Customer customer, Cart cart) {
        checkCart(cart);
        double subTotal = cart.calcSubTotal();
        double shippingFees = shippingService.getShippingFees(cart.getShippedItem());
        double amount = subTotal + shippingFees;
        customer.reduceBalance(amount);

        for (Product product : cart.getCart().keySet()) {
            int quantity = cart.getCart().get(product);
            product.reduceQuantity(quantity);
        }

        shippingService.ship(cart.getShippedItem());

        printReceipt(cart, subTotal, shippingFees, amount);

    }

    private void printReceipt(Cart cart, double subTotal ,double shippingFees ,double amount) {
        System.out.println("** Checkout receipt **");
        for (Product product : cart.getCart().keySet()) {
            int quantity = cart.getCart().get(product);
            double price = product.getPrice() * quantity;
            String name = product.getName();
            System.out.println(quantity + "x  " + name + "   " + price);
        }
        System.out.println("----------------------");
        System.out.println("Subtotal         " + subTotal);
        if (shippingFees>0)System.out.println("Shipping         " + shippingFees);
        System.out.println("Amount           " + amount);
    }


    public void checkCart(Cart cart) throws IllegalStateException {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty!");
    }
}
