package Model;

import java.io.Serializable;
import java.util.Date;

public class Table implements Serializable {
    private int number;
    private boolean available;
    private double money;
    private Date startTime;
    private Date endTime;
    public Table(){

    }

    public Table(int number, boolean available, double money, Date startTime, Date endTime) {
        this.number = number;
        this.available = available;
        this.money = money;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Table(int tableNum) {
        this.number = tableNum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        String status = available ? "Playing" : "Ready";
        return "Table: " +
                "number=" + number +
                ", available=" + status +
                ' ';
    }
}
