package org.example.billiard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Pool extends Table{
    @Override
    public BigDecimal getHourlyPrice() {
        return BigDecimal.valueOf(1200);
    }

    @Override
    public boolean reserveTable(LocalDateTime date) {
        if(available){
            available = false;
            reservationStart = date;
            System.out.println("Reserved pool table at: " + date.getHour());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "this is a pool table";
    }
}
