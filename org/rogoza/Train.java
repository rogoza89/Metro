package org.rogoza;

import java.util.ArrayList;
import java.util.List;

public class Train {
    Driver driver;

    List<Wagon> trainOfWagons = new ArrayList<>();

    @Override
    public String toString() {
        return "Train{" +
                "driver=" + driver +
                ", trainOfWagons=" + trainOfWagons +
                '}';
    }

    public void setDriver(Driver driver){
        this.driver = driver;
    }


}
