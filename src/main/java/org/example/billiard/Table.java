package org.example.billiard;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Table {
    boolean available;
    LocalDateTime reservationStart;

    public Table() {
        available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract BigDecimal getHourlyPrice();

    public abstract boolean reserveTable(LocalDateTime date);

    public BigDecimal calculateReservationPrice(LocalDateTime date) {
        long hours = ChronoUnit.HOURS.between(reservationStart, date);
        BigDecimal price = getHourlyPrice().multiply(BigDecimal.valueOf(hours));
        System.out.println("Table reservation cost for " + hours + "hours is " + price);
        return price;
    }
}
