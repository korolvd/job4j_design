package ru.job4j.ood.srp.report.store;

import ru.job4j.ood.srp.report.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {

    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee em) {
        employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> fiter) {
        return employees.stream().filter(fiter).collect(Collectors.toList());
    }
}
