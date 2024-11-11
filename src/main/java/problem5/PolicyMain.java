package problem5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PolicyMain
{
    public static void main(String[] args) {

        List<PolicyHolder> policyHolders = new ArrayList<>();

        policyHolders.add(new PolicyHolder(1, "John Doe", 65, "Life", 1200.0));
        policyHolders.add(new PolicyHolder(2, "Jane Smith", 70, "Life", 900.0));
        policyHolders.add(new PolicyHolder(3, "Alice Johnson", 45, "Health", 1500.0));
        policyHolders.add(new PolicyHolder(4, "Bob Brown", 75, "Life", 2000.0));
        policyHolders.add(new PolicyHolder(5, "Charlie White", 63, "Life", 1300.0));


        List<PolicyHolder> filteredByPolicyTypeAndAgeMoreThan60 = policyHolders.stream()
                .filter(a->a.getPolicyType().equalsIgnoreCase("Life")&&a.getAge()>60)
                .toList();
        filteredByPolicyTypeAndAgeMoreThan60.forEach(System.out::println);

        System.out.println("========================");

        List<RiskAssessment> listOfRiskAssessment=policyHolders.stream()
                .map(p->new RiskAssessment(p.getHolderId(), p.getName(),(p.getAge()/p.getPremiumAmount())))
                .toList();

        listOfRiskAssessment.forEach(System.out::println);

        System.out.println("========================");


        List<RiskAssessment> sortByDescScore=listOfRiskAssessment.stream()
                .sorted((a1,a2)->Double.compare(a2.getRiskScore(),a1.getRiskScore()))
                .toList();
        sortByDescScore.forEach(System.out::println);

        System.out.println("========================");

        Map<String,List<RiskAssessment>> groupByScore=listOfRiskAssessment.stream()
                .collect(Collectors.groupingBy(risk->risk.getRiskScore()>0.05?"HighRisk":"LowRisk"));

        groupByScore.forEach((k,v)->
        {
            System.out.println(k+"->");
            v.forEach(System.out::println);
        });

    }
}
