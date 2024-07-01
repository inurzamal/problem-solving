package org.example;

import org.example.dto.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {

        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "Rahul", "DevOps", 200));
        emp.add(new Employee(2, "Karan", "System",300));
        emp.add(new Employee(3, "Simran","DevOps",150));

        List<String> departments = emp.stream().map(Employee::getDepartment).distinct().toList();
        System.out.println(departments);

        Map<String, Long> map = emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(map);


        List<Employee> sortedList = emp.stream().sorted((o1,o2)-> (int) (o1.getSalary()-o2.getSalary())).collect(Collectors.toList());
        Double secondHighestSalary = sortedList.stream().map(Employee::getSalary).toList().get(sortedList.size() - 2);
        System.out.println(secondHighestSalary);

    }


}
