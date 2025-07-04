package service;

import model.cart.Cart;
import model.cutomer.Customer;

public interface CheckOutService {
    void checkOut(Customer customer , Cart cart);
}
