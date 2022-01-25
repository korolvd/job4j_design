package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.report.model.Employee;
import ru.job4j.ood.srp.report.store.Store;

import java.util.function.Predicate;

public class AccountingReport implements Report {

    private final double rate;
    private Store store;

    public AccountingReport(Store store, double rate) {
        this.rate = rate;
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * rate).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
