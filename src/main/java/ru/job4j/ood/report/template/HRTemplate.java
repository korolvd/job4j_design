package ru.job4j.ood.report.template;

import ru.job4j.ood.report.model.Employee;

import java.util.*;

public class HRTemplate implements ReportTemplate {
    @Override
    public String generate(List<Employee> employees) {
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary").append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

