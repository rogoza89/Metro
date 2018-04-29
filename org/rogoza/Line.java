package org.rogoza;

import java.util.ArrayList;
import java.util.List;

public class Line {


    List<Station> lineOfStations = new ArrayList<>();
    List<Train> trainsOfLine = new ArrayList<>();

    public Line(List<Station> lineOfStations) {
        this.lineOfStations = lineOfStations;
    }

    public void addTrainToLine(Train train){
        trainsOfLine.add(train);
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineOfStations=" + lineOfStations +
                ", trainsOfLine=" + trainsOfLine +
                '}';
    }
}
