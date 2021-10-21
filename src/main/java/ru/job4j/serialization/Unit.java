package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "unit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {
    @XmlAttribute
    private String type;
    @XmlAttribute
    private long id;
    @XmlAttribute
    private boolean run;
    private Coontroller controller;
    @XmlElementWrapper
    @XmlElement(name = "user")
    private String[] users;

    public Unit() {

    }

    public Unit(String type, long id, boolean run, Coontroller controller, String[] users) {
        this.type = type;
        this.id = id;
        this.run = run;
        this.controller = controller;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Unit{"
                + "type='" + type + '\''
                + ", id=" + id
                + ", run=" + run
                + ", controller=" + controller
                + ", users=" + Arrays.toString(users)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        Unit unit = new Unit("ESP", 20000521553L, true, new Coontroller("Novomet", 214125), new String[]{"Ivanov", "Sidorov"});
        System.out.println(unit);
        final Gson gson = new GsonBuilder().create();
        JAXBContext context = JAXBContext.newInstance(Unit.class);
        Marshaller marshaller = context.createMarshaller();
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(unit, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Unit result = (Unit) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
