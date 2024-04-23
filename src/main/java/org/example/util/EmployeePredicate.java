package org.example.util;

import org.example.entities.Employee;

import java.util.List;
import java.util.function.Predicate;

public class EmployeePredicate  {

    public double filteredSum(List<Employee> list, Predicate<Employee> criteria) {
        double sum = 0.0;
        for (Employee ep : list) {
            if (criteria.test(ep)) {
                sum += ep.getSalary();
            }
        }
        return sum;
    }


}
