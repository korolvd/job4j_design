package ru.job4j.ood.srp.report.template;

import ru.job4j.ood.srp.report.model.Employee;

import java.util.List;

public interface ReportTemplate {
    String generate(List<Employee> employees);
}
