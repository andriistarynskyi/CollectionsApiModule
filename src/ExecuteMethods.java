import entity.Deposit;
import service.DepositService;

import java.util.List;

public class ExecuteMethods {
    DepositService depositService = new DepositService();


    public boolean createReport() {
        System.out.println("Display all deposits.");
        depositService.getDeposits().forEach(d -> System.out.println(d));

        System.out.println("------------------------------");

        List<Deposit> deposits = depositService.getDeposits();
        System.out.println("The general sum of all deposits is " + depositService.getPrincipal(deposits) + ".");

        System.out.println("------------------------------");

        depositService.iterateOverCollection(deposits);

        System.out.println("------------------------------");

        System.out.println("Get sorted deposits by interest using Comparable interface.");
        depositService.getSortedDepositsByInterest(deposits).forEach(d -> System.out.println(d.getSum() + " -- " + d.getInterest()));
        System.out.println("------------------------------");

        System.out.println("Get sorted deposits by sum using Comparator interface.");
        depositService.getSortedDepositsBySum(deposits).forEach(d -> System.out.println(d));
        System.out.println("------------------------------");

        System.out.println("Get all deposits greater than 10000");
        depositService.getLargeDeposits(deposits).forEach(d -> System.out.println(d));
        System.out.println("------------------------------");

        System.out.println("Remove small deposits from list using lambda expression");
        depositService.removeSmallDeposits(deposits).forEach(d -> System.out.println(d));
        System.out.println("------------------------------");

        return true;
    }
}
