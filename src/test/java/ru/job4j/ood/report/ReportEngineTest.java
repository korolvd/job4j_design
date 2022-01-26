package ru.job4j.ood.report;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.ood.report.model.Employee;
import ru.job4j.ood.report.store.MemStore;

import java.time.OffsetDateTime;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new HTMLReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<table>")
                .append(System.lineSeparator())
                .append("<tr><th>Name</td><td>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append(System.lineSeparator())
                .append("<tr><td>")
                .append(worker.getName()).append("</td><td>")
                .append(worker.getHired()).append("</td><td>")
                .append(worker.getFired()).append("</td><td>")
                .append(worker.getSalary()).append("</td></tr>")
                .append(System.lineSeparator())
                .append("</table>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenOtherSalaryGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        double rate = 1.0 / 70.0;
        Report engine = new AccountingReport(store, rate);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * rate).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenFiltredFieldsGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Barsukov", now, now, 100);
        Employee worker2 = new Employee("Andreev", now, now, 600);
        store.add(worker1);
        store.add(worker2);
        Report engine = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new JSONReport(store);
        StringBuilder expect = new StringBuilder()
                .append("[{\"name\":\"").append(worker.getName()).append("\",")
                .append("\"hired\":{")
                .append("\"year\":").append(worker.getHired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getHired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getHired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getHired().get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getHired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getHired().get(Calendar.SECOND)).append("},")
                .append("\"fired\":{")
                .append("\"year\":").append(worker.getFired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getFired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getFired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getFired().get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getFired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getFired().get(Calendar.SECOND)).append("},")
                .append("\"salary\":").append(worker.getSalary()).append("}]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        OffsetDateTime date = OffsetDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId());
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new XMLReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append("        <fired>")
                .append(date).append("</fired>\n")
                .append("        <hired>")
                .append(date).append("</hired>\n")
                .append("        <name>")
                .append(worker.getName()).append("</name>\n")
                .append("        <salary>")
                .append(worker.getSalary()).append("</salary>\n")
                .append("    </employee>\n")
                .append("</employees>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}