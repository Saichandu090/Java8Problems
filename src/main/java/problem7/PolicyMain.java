package problem7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

public class PolicyMain
{
    public static void main(String[] args) {

        List<Policy> policies = new ArrayList<>();

        policies.add(new Policy(1, 1001, LocalDate.of(2024, 11, 15), 1200.0, "Active"));
        policies.add(new Policy(2, 1002, LocalDate.of(2024, 11, 10), 900.0, "Active"));
        policies.add(new Policy(3, 1001, LocalDate.of(2024, 11, 1), 1500.0, "Inactive"));
        policies.add(new Policy(4, 1003, LocalDate.of(2024, 11, 25), 1300.0, "Active"));
        policies.add(new Policy(5, 1002, LocalDate.of(2024, 11, 20), 2000.0, "Active"));


        List<Policy> dueForRenewal = policies.stream()
                .filter(a->a.getExpiryDate().isBefore(LocalDate.from(LocalDate.now().plusMonths(1))) && a.getStatus().equalsIgnoreCase("Active"))
                .toList();

        dueForRenewal.forEach(System.out::println);

        System.out.println("==================");

        List<RenewalRemainder> renewalRemainders=policies.stream()
                .map(a-> new RenewalRemainder(a.getPolicyId(), a.getPolicyHolderId(), a.getExpiryDate().getDayOfMonth() - LocalDate.now().getDayOfMonth()))
                .toList();

        renewalRemainders.forEach(System.out::println);


        System.out.println("==================");

        List<RenewalRemainder> sortForExpiryDate = renewalRemainders.stream()
                .sorted(Comparator.comparingInt(RenewalRemainder::getDaysRemaining))
                .toList();

        sortForExpiryDate.forEach(System.out::println);


        System.out.println("==================");

        Map<Integer,List<RenewalRemainder>> groupByPolicyHolderId = renewalRemainders.stream()
                .collect(Collectors.groupingBy(RenewalRemainder::getPolicyHolderId));

        groupByPolicyHolderId.forEach((k, v) -> {
            System.out.println(k + " -> ");
            v.forEach(System.out::println);
        });
    }
}
