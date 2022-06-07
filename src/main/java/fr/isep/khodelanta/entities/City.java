package fr.isep.khodelanta.entities;

import java.util.Arrays;
import java.util.Optional;

public enum City {
    PARIS1("Paris - 1"),
    PARIS2("Paris - 2"),
    PARIS3("Paris - 3"),
    PARIS4("Paris - 4"),
    PARIS5("Paris - 5"),
    PARIS6("Paris - 6"),
    PARIS7("Paris - 7"),
    PARIS8("Paris - 8"),
    PARIS9("Paris - 9"),
    PARIS10("Paris - 10"),
    PARIS11("Paris - 11"),
    PARIS12("Paris - 12"),
    PARIS13("Paris - 13"),
    PARIS14("Paris - 14"),
    PARIS15("Paris - 15"),
    PARIS16("Paris - 16"),
    PARIS17("Paris - 17"),
    PARIS18("Paris - 18"),
    PARIS19("Paris - 19"),
    PARIS20("Paris - 20");



    private final String name;

    City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
