package service;

import entity.DepoType;
import entity.Deposit;

import java.time.LocalDate;
import java.util.*;

public class DepositService {
    public List<Deposit> getDeposits() {
        List<Deposit> deposits = new ArrayList<>();

        deposits.add(new Deposit(
                DepoType.SIMPLE, LocalDate.of(2013, 8, 9), 61, 2500.00, 18.0));
        deposits.add(new Deposit(
                DepoType.MONTH_CAPIT, LocalDate.of(2012, 1, 2), 181, 10000.00, 21.0));
        deposits.add(new Deposit(
                DepoType.SIMPLE, LocalDate.of(2013, 12, 11), 30, 5500.00, 15.3));
        deposits.add(new Deposit(
                DepoType.BARRIER, LocalDate.of(2011, 12, 18), 370, 43000.00, 19.56));
        deposits.add(new Deposit(
                DepoType.MONTH_CAPIT, LocalDate.of(2013, 12, 07), 30, 12000.00, 16.0));
        return deposits;
    }

    public boolean iterateOverCollection(List<Deposit> deposits) {
        System.out.println("Iterate over collection using stream API.");
        iterateUsingStreamApi(deposits);
        System.out.println("----------------------");
        System.out.println("Iterate over collection using iterator.");
        iterateUsingIterator(deposits);
        System.out.println("----------------------");
        System.out.println("Iterate over collection using while loop.");
        iterateUsingWhileLoop(deposits);
        return true;
    }

    public double getPrincipal(List<Deposit> deposits) {
        double sum = 0;
        for (Deposit d : deposits) {
            sum += d.getSum();
        }
        return sum;
    }

    public boolean iterateUsingStreamApi(List<Deposit> deposits) {
        deposits.forEach(d -> System.out.println(d));
        return true;
    }

    public boolean iterateUsingIterator(List<Deposit> deposits) {
        Iterator<Deposit> depositIterator = deposits.iterator();
        while (depositIterator.hasNext()) {
            System.out.println(depositIterator.next());
        }
        return true;
    }

    public boolean iterateUsingWhileLoop(List<Deposit> deposits) {
        int i = 0;
        while (i < deposits.size()) {
            System.out.println(deposits.get(i));
            i++;
        }
        return true;
    }

    public List<Deposit> getSortedDepositsByInterest(List<Deposit> deposits) {
        Collections.sort(deposits);
        return deposits;
    }

    Comparator<Deposit> sortBySum = (Deposit a, Deposit b) -> (int) (b.getSum() - a.getSum());

    public List<Deposit> getSortedDepositsBySum(List<Deposit> deposits) {
        Collections.sort(deposits, sortBySum);
        return deposits;
    }

    public List<Deposit> getLargeDeposits(List<Deposit> deposits) {
        Iterator<Deposit> iter = deposits.iterator();
        while (iter.hasNext()) {
            if (iter.next().getSum() < 10000.00) {
                iter.remove();
            }
        }
        return deposits;
    }

    public List<Deposit> removeSmallDeposits(List<Deposit> deposits) {
        deposits.removeIf(d -> (d.getSum() < 10000.00));
        return deposits;
    }
}