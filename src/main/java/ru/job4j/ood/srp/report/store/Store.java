package ru.job4j.ood.srp.report.store;

import ru.job4j.ood.srp.report.model.Employee;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Employee> findBy(Predicate<Employee> fiter);
}
