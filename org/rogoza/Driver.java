package org.rogoza;

import java.util.Random;

public class Driver {
    String name;
    int experience;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }

    public void changeExperience(){
        Random rnd = new Random();
        setExperience(this.experience+rnd.nextInt(201)-150);
    }
}
