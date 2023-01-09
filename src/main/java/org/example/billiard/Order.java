package org.example.billiard;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Beverage> beverages;
    private Table table;

    public Order(Table table) {
        this.table = table;
    }

    List<Beverage> getBeverages(){
        if(beverages == null){
            beverages = new ArrayList<>();
        }
        return beverages;
    }

    public void addBeverage(Beverage beverage){
        getBeverages().add(beverage);
    }

    public void payBeverage(String name, BigDecimal price){
        for(Beverage beverage : beverages){
            if(beverage.getPrice().equals(price) && beverage.getName().equals(name)){
                System.out.println("Paid beverage " + beverage.getName() + ": " + beverage.getPrice());
                beverages.remove(beverage);
                break;
            }
        }
    }

    public BigDecimal calculateUnpaid(LocalDateTime date){
        BigDecimal total = BigDecimal.ZERO;
        if(beverages != null) {
            for (Beverage beverage : beverages) {
                total.add(beverage.getPrice());
            }
        }
        return total.add(table.calculateReservationPrice(date));
    }

    public BigDecimal payAll(LocalDateTime date){
        table.setAvailable(true);
        System.out.println("paid order: " + calculateUnpaid(date) + "HUF");
        return calculateUnpaid(date);
    }

    @Override
    public String toString() {
        return "created order for table: " + table + "and the items are: " + beverages;
    }
}
