package ru.job4j.ood.srp.report.template;

import java.util.List;
import ru.job4j.ood.srp.report.model.Employee;

public class HTMLTemplate implements ReportTemplate {
    @Override
    public String generate(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("<table>")
                .append(System.lineSeparator())
                .append("<tr><th>Name</td><td>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append("<tr><td>")
                    .append(employee.getName()).append("</td><td>")
                    .append(employee.getHired()).append("</td><td>")
                    .append(employee.getFired()).append("</td><td>")
                    .append(employee.getSalary()).append("</td></tr>")
                    .append(System.lineSeparator());
        }
        text.append("</table>");
        return text.toString();
    }
}
