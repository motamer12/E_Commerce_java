package service;

import model.product.Product;
import model.product.Shippable;

import java.util.Map;

public interface ShippingService {
        void ship(Map<Shippable,Integer>shipped);
        double getShippingFees (Map<Shippable, Integer> shipped);
}
