package org.example.practices;

import org.example.dto.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class HighestSalaryOfEachDept {

    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(1, "Rahul", "HR", 500));
        empList.add(new Employee(1, "Rahul", "HR", 600));
        empList.add(new Employee(1, "Rahul", "Dev", 1500));
        empList.add(new Employee(1, "Rahul", "Dev", 1200));

        Comparator<Employee> comp = Comparator.comparing(Employee::getSalary);

        Map<String, Optional<Employee>> map = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(comp))));

        //System.out.println(map);
        map.forEach((department, employee) ->
                System.out.println(department + ": " + (employee.isPresent() ? employee.get() : "No employees"))
        );
    }
}

