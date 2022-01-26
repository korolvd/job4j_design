package ru.job4j.ood.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.report.model.Employee;
import ru.job4j.ood.report.store.Store;

import java.util.function.Predicate;

public class JSONReport implements Report {

    private Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(store.findBy(filter));
    }
}
