package service.impl;

import model.product.Product;
import model.product.Shippable;
import service.ShippingService;

import java.util.Map;

public class ShippingProcess implements ShippingService {


    @Override
    public void ship(Map<Shippable, Integer> shipped) {
        if (checkShipped(shipped)){
            System.out.println("** Shipment notice **");
            double totalWeight =0.0;
            for (Shippable product :shipped.keySet()){
                int quantity=shipped.get(product);
                double weight =product.getWeight();
                String name =product.getName();
                System.out.println(quantity+"x  "+name+"   "+weight*quantity+"g.");
                totalWeight+=weight/1000;
            }
            System.out.println("Total package weight:  "+totalWeight+"Kg.");
        }
    }

    @Override
    public double getShippingFees(Map<Shippable, Integer> shipped) {
        double shippingFees;
        if (!checkShipped(shipped)) shippingFees =0;
        else shippingFees=30.0;
        return shippingFees;
    }

    public boolean checkShipped (Map<Shippable, Integer> shipped){
        return !shipped.isEmpty();
    }
}
