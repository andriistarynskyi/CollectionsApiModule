package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Deposit implements Comparable<Deposit> {
    private int id;
    private DepoType depoType;
    private LocalDate startDate;
    private int dayLong;
    private double sum;
    private double interest;

    public Deposit() {
    }

    public Deposit(DepoType depoType, LocalDate startDate, int dayLong, double sum, double interest) {
        this.depoType = depoType;
        this.startDate = startDate;
        this.dayLong = dayLong;
        this.sum = sum;
        this.interest = interest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepoType getDepoType() {
        return depoType;
    }

    public void setDepoType(DepoType depoType) {
        this.depoType = depoType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDayLong() {
        return dayLong;
    }

    public void setDayLong(int dayLong) {
        this.dayLong = dayLong;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "entity.Deposit{" +
                "id=" + id +
                ", depoType=" + depoType +
                ", startDate=" + startDate +
                ", dayLong=" + dayLong +
                ", sum=" + sum +
                ", interest=" + interest +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deposit)) return false;
        Deposit deposit = (Deposit) o;
        return getId() == deposit.getId() && getDayLong() == deposit.getDayLong() && Double.compare(deposit.getSum(), getSum()) == 0 && Double.compare(deposit.getInterest(), getInterest()) == 0 && getDepoType() == deposit.getDepoType() && getStartDate().equals(deposit.getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepoType(), getStartDate(), getDayLong(), getSum(), getInterest());
    }

    @Override
    public int compareTo(Deposit a) {
        if (interest == a.getInterest()) {
            return 0;
        } else if (interest < a.interest) {
            return 1;
        } else {
            return -1;
        }
    }
}