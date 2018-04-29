package org.rogoza;

import java.util.ArrayList;
import java.util.List;

public class Station {
    String name ;

    List<Passenger> passengers = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }




}
