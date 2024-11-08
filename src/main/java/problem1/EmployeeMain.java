package problem1;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeMain
{
    public static void main(String[] args) {

        List<Employee> employeeList=List.of(new Employee(1,"Sai chandu","Engineering",85678.45),
                                            new Employee(5,"Dinesh","Mechatronics",55678.45),
                                            new Employee(2,"Jenisha","Engineering",35678.45),
                                            new Employee(8,"Saurav","CSE",95678.45),
                                            new Employee(6,"Rahil Raut","Degree",75678.35));

        List<Employee> salGreaterThan80=employeeList.stream()
                .filter(emp->emp.getSalary()>80000 && emp.getDepartment().equalsIgnoreCase("Engineering"))
                .toList();
        salGreaterThan80.forEach(System.out::println);

        System.out.println("==================");

        List<Employee> sortInDescBySal=employeeList.stream()
                .sorted((e1,e2)-> (int) (e2.getSalary()-e1.getSalary()))
                .toList();
        sortInDescBySal.forEach(System.out::println);

        System.out.println("==================");

        Map<String,List<Employee>> groupByDept=employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupByDept.forEach((k,v)->{
            System.out.println(k+" -> ");
            v.forEach(System.out::println);
        });

        System.out.println("==================");

        Map<String, Double> avgSalForEachDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        avgSalForEachDept.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}
