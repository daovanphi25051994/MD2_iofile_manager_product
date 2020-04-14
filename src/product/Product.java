package product;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String id;
    private String brand;
    private double price;
    private String describable;

    public Product() {
    }

    public Product(String name, String id, String brand, double price, String describable) {
        this.name = name;
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.describable = describable;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getDescribable() {
        return describable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescribable(String describable) {
        this.describable = describable;
    }

    @Override
    public String toString() {
        return this.name + " " + this.id + " " + this.brand + " " + this.price + " " + this.describable;
    }
}
