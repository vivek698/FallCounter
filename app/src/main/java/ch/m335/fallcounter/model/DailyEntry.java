package ch.m335.fallcounter.model;

import java.time.LocalDate;

public class DailyEntry {
    private int counter;
    private LocalDate date;

    public DailyEntry(int counter, LocalDate date) {
        this.counter = counter;
        this.date = date;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
