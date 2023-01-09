package org.example.billiard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rex extends Table{
    @Override
    public BigDecimal getHourlyPrice() {
        return BigDecimal.valueOf(800);
    }

    @Override
    public boolean reserveTable(LocalDateTime date) {
        if(available && date.getHour() >= 18){
            available = false;
            reservationStart = date;
            System.out.println("Reserved pool table at: " + date.getHour());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "this is a rex table";
    }
}
