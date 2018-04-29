package org.rogoza;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Depo {

    List<Wagon> depo = new ArrayList<>();

    public List<Wagon> createDepo(){
        Random rnd = new Random();
        for (int i = 0; i < 100 ; i++) {
            if (rnd.nextInt(100) < 30)
                depo.add(new HeadWagon());
            else
                depo.add(new RegularWagon());
        }
        return depo;
    }

}
