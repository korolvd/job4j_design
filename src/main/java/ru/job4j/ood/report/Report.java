package ru.job4j.ood.report;

import ru.job4j.ood.report.model.Employee;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
