package ch.m335.fallcounter.model;

import java.util.Date;

public class DailyEntry {
    private int counter;
    private Date date;

    public DailyEntry(int counter, Date date) {
        this.counter = counter;
        this.date = date;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
