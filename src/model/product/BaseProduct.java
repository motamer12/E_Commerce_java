package model.product;

public abstract class BaseProduct implements Product{

    protected String name ;
    protected int price ;
    protected int quantity ;

    public BaseProduct (String name,int price ,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
    @Override
    public abstract boolean isAvialble(int amount);

    @Override
    public void reduceQuantity(int amount) {
        if (isAvialble(amount)){
            this.quantity -= amount;
        }else {
            throw new IllegalArgumentException("amount must be postive and smaller or equal the quantity");
        }
    }

}
