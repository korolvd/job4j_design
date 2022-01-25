package ru.job4j.ood.report.store;

import ru.job4j.ood.report.model.Employee;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Employee> findBy(Predicate<Employee> fiter);
}
