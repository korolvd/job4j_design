package ru.job4j.ood.srp.report.template;

import ru.job4j.ood.srp.report.model.Employee;

import java.util.List;

public class AccountingTemplate implements ReportTemplate {
    private double rate = 1.0d;

    public AccountingTemplate() {

    }

    public AccountingTemplate(double rate) {
        this.rate = rate;
    }

    @Override
    public String generate(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary").append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * rate).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
