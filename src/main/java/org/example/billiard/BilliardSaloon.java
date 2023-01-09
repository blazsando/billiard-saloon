package org.example.billiard;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BilliardSaloon {

    List<Table> tables = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    public void addTable(Table table){
        tables.add(table);
    }

    public List<Rex> availableRexTables(){
        List<Rex> filtered = new ArrayList<>();
        for(Table table: tables){
            if(table instanceof Rex && table.available){
                filtered.add((Rex) table);
            }
        }
        return filtered;
    }

    public List<Snooker> availableSnookerTables(){
        List<Snooker> filtered = new ArrayList<>();
        for(Table table: tables){
            if(table instanceof Snooker && table.available){
                filtered.add((Snooker) table);
            }
        }
        return filtered;
    }

    public List<Pool> availablePoolTables(){
        List<Pool> filtered = new ArrayList<>();
        for(Table table: tables){
            if(table instanceof Pool && table.available){
                filtered.add((Pool) table);
            }
        }
        return filtered;
    }

    public Order reserveTable(Table table, LocalDateTime date){
        if(table.reserveTable(date)){
            Order newOrder = new Order(table);
            orders.add(newOrder);
            return newOrder;
        }
        return null;
    }

    public Order getHighestUnpaidOrder(LocalDateTime date){
        Order highestUnpaid = orders.get(0);
        for(Order order: orders){
            if(highestUnpaid.calculateUnpaid(date).compareTo(order.calculateUnpaid(date)) < 0){
                highestUnpaid = order;
            }
        }

        return highestUnpaid;
    }

    public void payOrder(Order order, LocalDateTime date){
        order.payAll(date);
        orders.remove(order);
    }
}
