import model.cart.Cart;
import model.cutomer.Customer;
import model.product.Product;
import model.product.impl.*;
import service.CheckOutService;
import service.ShippingService;
import service.impl.CheckOutProcess;
import service.impl.ShippingProcess;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Mohamed", 1000.0);

        Product digitalProduct = new DigitalProduct("E-Book", 50, 10);
        Product shippedProduct = new ShippedProduct("Laptop", 500, 5, 2000);
        Product perishableProduct = new PerishableProduct("Cheese", 20, 8, LocalDate.now().plusDays(5), 500);
        Product perishableShipped = new PerishableShipped("Fresh Fish", 30, 6, LocalDate.now().plusDays(2));

        Cart cart = new Cart();

        cart.addItem(digitalProduct, 2);
        cart.addItem(shippedProduct, 1);
        cart.addItem(perishableProduct, 3);
        cart.addItem(perishableShipped, 2);

        ShippingService shippingService = new ShippingProcess();
        CheckOutService checkOutService = new CheckOutProcess(shippingService);

        checkOutService.checkOut(customer, cart);
        System.out.println("\nCustomer balance after purchase: " + customer.getBalance());

    }
}
