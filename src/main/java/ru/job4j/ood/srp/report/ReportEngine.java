package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.report.model.Employee;
import ru.job4j.ood.srp.report.store.Store;
import ru.job4j.ood.srp.report.template.DefaultTemplate;
import ru.job4j.ood.srp.report.template.ReportTemplate;

import java.util.function.Predicate;

import java.util.stream.Stream;

public class ReportEngine implements Report {

    private Store store;
    private ReportTemplate template = new DefaultTemplate();

    public ReportEngine(Store store) {
        this.store = store;
    }

    public ReportEngine(Store store, ReportTemplate template) {
        this.store = store;
        this.template = template;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return template.generate(store.findBy(filter));
    }
}
