package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "controller")
public class Coontroller {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int id;

    public Coontroller() {

    }

    public Coontroller(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Coontroller{"
                + "name='" + name + '\''
                + ", id=" + id
                + '}';
    }
}
