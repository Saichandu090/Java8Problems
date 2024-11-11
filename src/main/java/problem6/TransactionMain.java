package problem6;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionMain
{
    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        // Adding sample transactions to the list
        transactions.add(new Transaction(1, "P123", 12000.0, LocalDate.of(2023, 10, 15), true));
        transactions.add(new Transaction(2, "P124", 15000.0, LocalDate.of(2023, 9, 5), true));
        transactions.add(new Transaction(3, "P123", 5000.0, LocalDate.of(2023, 10, 10), true));
        transactions.add(new Transaction(4, "P123", 30000.0, LocalDate.of(2023, 7, 1), true));
        transactions.add(new Transaction(5, "P125", 60000.0, LocalDate.of(2023, 6, 15), true));
        transactions.add(new Transaction(6, "P125", 25000.0, LocalDate.of(2023, 5, 10), false));
        transactions.add(new Transaction(7, "P123", 12000.0, LocalDate.of(2023, 8, 23), true));


        List<Transaction> trueAndAmountMoreThan10000=transactions.stream()
                .filter(a-> a.isFraudulent() && a.getAmount()>10000.0)
                .toList();

        trueAndAmountMoreThan10000.forEach(System.out::println);

        System.out.println("====================");

        Map<String,List<Transaction>> groupByPolicyNumber=transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        groupByPolicyNumber.forEach((k,v)->{
            System.out.println(k+"->");
            v.forEach(System.out::println);
        });

        System.out.println("====================");

        Map<String, Map<Boolean,Double>> ap=transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber,Collectors.groupingBy(Transaction::isFraudulent,Collectors.summingDouble(Transaction::getAmount))));

        ap.forEach((k,v)->
        {
            System.out.println(k+"->");
            v.forEach((o,i)-> System.out.println(o+" -> "+i));
        });

        System.out.println("====================");

        List<Map.Entry<String, List<Transaction>>> policyWithMoreThan50000=groupByPolicyNumber.entrySet().stream()
                .filter(a -> a.getValue().stream().mapToDouble(Transaction::getAmount).sum() > 50000)
                .toList();

        System.out.println("Alert For Policy Numbers With Amount More Than 50000");
        policyWithMoreThan50000.forEach(System.out::println);


    }
}
