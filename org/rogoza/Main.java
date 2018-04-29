package org.rogoza;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Depo depo = new Depo();

        List<Wagon> depoOfRandomTrains = depo.createDepo();

        for (Wagon wagon : depoOfRandomTrains) {
            System.out.println(wagon);
        }

        List<Train> trains = createTrain(depoOfRandomTrains);

        for (Train train1 : trains) {
            System.out.println(train1);
        }

        Queue<Driver> driverQueue = createQueueOfRandomExperiencedDrivers();

        System.out.println(driverQueue);

        setDriverOnTrain(trains, driverQueue);

        System.out.println(driverQueue);

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Station> stations = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                stations.add(new Station("Station" + j));
            }
                lines.add(new Line(stations));
        }
        runTrainOnLines(trains,lines);
    }

        public static Queue<Driver> createQueueOfRandomExperiencedDrivers(){

            Comparator<Driver> comparator = new Comparator<Driver>() {
                @Override
                public int compare(Driver o1, Driver o2) {
                    if (o2.experience > o1.experience) {
                        return 1;
                    }
                    if (o2.experience < o1.experience) {
                        return -1;
                    }
                    return 0;
                }

            };

            Queue<Driver> driverQueue = new PriorityQueue<Driver>(comparator);
            Random rnd = new Random();
            for (int i = 0; i < 8; i++) {
                driverQueue.add(new Driver("Driver" +i, rnd.nextInt(201)-100));
            }
            return driverQueue;
        }




    public static List<Train> createTrain(List<Wagon> depoOfRandomTrains) {

        Iterator<Wagon> iter = depoOfRandomTrains.iterator();
        List<Train> trains = new ArrayList<>();
        Train train = new Train();
        while (iter.hasNext()) {
            Wagon wagon = iter.next();

            if(wagon instanceof HeadWagon) {
                if (train.trainOfWagons.size() == 0 || train.trainOfWagons.size() == 4) {
                    train.trainOfWagons.add(wagon);
                }
            } else {
                if(train.trainOfWagons.size() > 0 && train.trainOfWagons.size() < 4){
                    train.trainOfWagons.add(wagon);
                }
            }
            if (train.trainOfWagons.size() == 5) {
                trains.add(train);
                train = new Train();
            }

        }

        return trains;
    }

    public static void setDriverOnTrain(List<Train> trains, Queue<Driver> driverQueue){
        Iterator<Train> trainIterator = trains.iterator();
        while (trainIterator.hasNext()){
            Train train = trainIterator.next();
            Driver driver = driverQueue.poll();
            train.setDriver(driver);
            System.out.println("dr "  +driver+" -------  "+ train.hashCode());
            driver.changeExperience();
            driverQueue.add(driver);
        }

    }

    public static void runTrainOnLines(List<Train> trains, List<Line> lines){
        Iterator<Train> trainIterator = trains.iterator();
        while (trainIterator.hasNext()){

            for (int i = 0; i < lines.size() ; i++) {
                if(trainIterator.hasNext()) {
                    Train train = trainIterator.next();
                    lines.get(i).addTrainToLine(train);
                }
            }

        }
    }

    public static void runTrainsOnStations(List<Line> lines, List<Train> trains, List<Station> stations){
        for (Line line: lines) {
            for (Train train: trains){

                for (Station station: stations){

                    for(Wagon wagon: train.trainOfWagons){

                    }
                }

            }
        }
    }

}


