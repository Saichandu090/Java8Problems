package problem8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerMain
{
    public static void main(String[] args) {

        List<CustomerTransaction> transactions = new ArrayList<>();

        transactions.add(new CustomerTransaction(1, LocalDate.of(2023, 10, 15), 1200.0));
        transactions.add(new CustomerTransaction(1, LocalDate.of(2024, 9, 5), 1500.0));
        transactions.add(new CustomerTransaction(2, LocalDate.of(2023, 8, 23), 3000.0));
        transactions.add(new CustomerTransaction(3, LocalDate.of(2024, 6, 10), 2500.0));
        transactions.add(new CustomerTransaction(2, LocalDate.of(2023, 10, 1), 2000.0));
        transactions.add(new CustomerTransaction(3, LocalDate.of(2024, 10, 20), 1000.0));
        transactions.add(new CustomerTransaction(4, LocalDate.of(2022, 12, 10), 5000.0));

        List<CustomerTransaction> transactionsIn2023 = transactions.stream()
                .filter(transaction -> transaction.getTransactionDate().isAfter( LocalDate.of(2023,11,11)))
                .toList();
        transactionsIn2023.forEach(System.out::println);


        System.out.println("==================");

        Map<Integer,Double> totalAmountByCustomer = transactions.stream()
                .collect(Collectors.groupingBy(CustomerTransaction::getCustomerId,Collectors.summingDouble(CustomerTransaction::getTransactionAmount)));

        System.out.println("Total amount for customer with Id:");

        totalAmountByCustomer.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });

        Map<Integer, Double> AvgAmountByCustomer = transactions.stream()
                .collect(Collectors.groupingBy(CustomerTransaction::getCustomerId,Collectors.averagingDouble(CustomerTransaction::getTransactionAmount)));


        System.out.println("Avg amount for customer with Id:");
        AvgAmountByCustomer.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });


        System.out.println("==================");

        List<CustomerTransaction> sortByAmount = transactions.stream()
                .sorted((t1, t2) ->Double.compare(t2.getTransactionAmount(), t1.getTransactionAmount()))
                .toList();
        sortByAmount.forEach(System.out::println);

        System.out.println("==================");

        List<CustomerTransaction> top3 = transactions.stream()
                .sorted((t1, t2) -> Double.compare(t2.getTransactionAmount(), t1.getTransactionAmount()))
                .limit(3)
                .toList();

        top3.forEach(System.out::println);

    }
}
