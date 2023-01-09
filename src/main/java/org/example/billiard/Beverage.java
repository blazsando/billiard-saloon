package org.example.billiard;

import java.math.BigDecimal;

public class Beverage {
    private BeverageType type;
    private String name;
    private BigDecimal price;

    public Beverage(BeverageType type, String name, BigDecimal price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ":" + price + "HUF";
    }
}
