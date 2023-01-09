package org.example;

import org.example.billiard.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BilliardSaloon saloon = new BilliardSaloon();
        Rex rexTable = new Rex();
        Pool poolTable = new Pool();
        Snooker snookerTable = new Snooker();
        saloon.addTable(rexTable);
        saloon.addTable(poolTable);
        saloon.addTable(snookerTable);

        List<Rex> rexTables = saloon.availableRexTables();
        List<Pool> poolTables = saloon.availablePoolTables();
        System.out.println(poolTables);
        System.out.println(rexTables);
        System.out.println(saloon.availableSnookerTables());
        System.out.println(saloon.reserveTable(rexTables.get(0), LocalDateTime.now()));
        Order orderOfPool = saloon.reserveTable(poolTables.get(0), LocalDateTime.now());
        System.out.println(orderOfPool);
        Order orderOfRex = saloon.reserveTable(rexTables.get(0), LocalDateTime.now().plusHours(2));
        System.out.println(orderOfRex);
        Beverage cola = new Beverage(BeverageType.DRINK, "Cola", BigDecimal.valueOf(700));
        orderOfPool.addBeverage(cola);
        System.out.println(orderOfPool);
        Order highestUnpaid = saloon.getHighestUnpaidOrder(LocalDateTime.now().plusHours(3));
        System.out.println(highestUnpaid);

    }
}