package ru.job4j.ood.report.template;

import ru.job4j.ood.report.model.Employee;

import java.util.List;

public interface ReportTemplate {
    String generate(List<Employee> employees);
}
