package problem4;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClaimMain
{
    public static void main(String[] args) {

        List<Claim> claims= List.of(new Claim(1, "P123", 10000.99, LocalDate.of(2024,8,24), "Pending"),
                                    new Claim(2, "P124", 9500.0,LocalDate.of(2024,10,13), "Approved"),
                                    new Claim(3, "P123", 5500.00,LocalDate.of(2023,12,2), "Rejected"),
                                    new Claim(4, "P125", 4000.90,LocalDate.of(2024,7,15), "Pending"),
                                    new Claim(5, "P124", 2500.0,LocalDate.of(2024,10,13), "Approved"));

        List<Claim> approvedWithAbove5000=claims.stream()
                .filter(s-> s.getStatus().equalsIgnoreCase("Approved") && s.getClaimAmount() > 5000)
                .toList();
        approvedWithAbove5000.forEach(System.out::println);

        System.out.println("======================");

        Map<String,List<Claim>> groupByPolicyNumber=claims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        groupByPolicyNumber.forEach((k,v)->
        {
            System.out.println(k+"->");
            v.forEach(System.out::println);
        });

        System.out.println("======================");

        Map<String,Double> forEachPolicyAvgAmount=claims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber,Collectors.averagingDouble(Claim::getClaimAmount)));

        System.out.println("forEachPolicyAvgAmount:");
        forEachPolicyAvgAmount.forEach((k,v)->
        {
            System.out.println(k+" -> "+v);
        });

        Map<String,Double> forEachPolicyTotalAmount=claims.stream()
                        .collect(Collectors.groupingBy(Claim::getPolicyNumber, Collectors.summingDouble(Claim::getClaimAmount)));

        System.out.println("forEachPolicyTotalAmount:");
        forEachPolicyTotalAmount.forEach((k,v)->
        {
            System.out.println(k+" -> "+v);
        });

        System.out.println("=======================");

        Stream<Map.Entry<String,Double>> top3=forEachPolicyTotalAmount.entrySet().stream()
                .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue())).limit(3);

        top3.forEach(System.out::println);
    }
}
