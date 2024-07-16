package org.example.practices;

import org.example.dto.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {

        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "Rahul", "DevOps", 200));
        emp.add(new Employee(2, "Karan", "System",300));
        emp.add(new Employee(3, "Simran","DevOps",150));
        emp.add(new Employee(4, "Raju", "System",500));
        // Find Distinct Departments
        List<String> departments = emp.stream().map(Employee::getDepartment).distinct().toList();
        System.out.println("Distinct Departments: "+ departments);

        //Count Each Department
        Map<String, Long> map = emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Department Count: "+ map);

        //Sort employee based on names
        System.out.println("Sort based on names: ");
        emp.stream().sorted((o1,o2)->o1.getName().compareTo(o2.getName())).forEach(e-> System.out.println(e));

        // Sort Employee based on salary
        List<Employee> sortedList = emp.stream().sorted((o1,o2)-> (int) (o1.getSalary()-o2.getSalary())).collect(Collectors.toList());
        System.out.println("Sort based on salary: ");
        sortedList.forEach(System.out::println);

        //Find Second-highest Salary
        Double secondHighestSalary = sortedList.stream().map(Employee::getSalary).toList().get(sortedList.size() - 2);
        System.out.println("Second Highest Salary: "+ secondHighestSalary);

        // Employee having salary less than 200 need to increase by 20%
        System.out.println("Employee having salary less than 200 need to increase by 20%:");
        emp.stream()
                .filter(e -> e.getSalary() < 200)
                .forEach(e -> e.setSalary(e.getSalary() * 1.20));

        emp.forEach(System.out::println);

        // Department wise Highest Salary
        System.out.println("Department wise Highest Salary:");
        Comparator<Employee> comparing = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> optionalMap = emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(comparing)));
        optionalMap.forEach((i,j)-> System.out.println(i+" "+(j.isPresent()?j.get():"Not Available")));

    }

}
