package Application;

import java.util.ArrayList;

/**
 * Comp 2071
 * Lab 03: Queues
 * Due: February 23rd, 2016
 * Group #: 15
 * <p>
 * A class to represent a TrainRoute
 * Also contains the main method for the application
 *
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

public class TrainRoute {
    private ArrayList<Train> trains;

    /**
     * Constructor for TrainRoute
     *
     * @param trains
     */
    public TrainRoute(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public static void main(String[] args) {
        // Create trains
        ArrayList<Train> trains = new ArrayList<Train>();
        trains.add(new Train(Train.Direction.OUTBOUND, 3, TrainRoute.Station.StationF));
        trains.add(new Train(Train.Direction.OUTBOUND, 4, TrainRoute.Station.StationD));
        trains.add(new Train(Train.Direction.INBOUND, 3, TrainRoute.Station.StationA));
        trains.add(new Train(Train.Direction.INBOUND, 4, TrainRoute.Station.StationD));
        // Create the train route
        TrainRoute tr = new TrainRoute(trains);
        tr.runSimulation(20);
    }

    public void runSimulation(int numUpdates) {
        // Update loop
        boolean update = true;
        int numberOfUpdates = numUpdates;
        while (update && numberOfUpdates > 0) {
            System.out.println("-------------------------------------------");
            // Update stations
            for (Station station : Station.values()) {
                station.getStation().update();
            }

            // Update trains
            for (Train train : trains) {
                train.update();
            }

            // Loop limiter
            numberOfUpdates--;
        }
    }

    /**
     * Enum for a stations position in the route
     * (stationValue, distanceToNextStation)
     */
    public enum Station {
        StationA(0, 1), StationB(1, 2), StationC(2, 3), StationD(3, 4), StationE(4, 3), StationF(5, 2);

        private final static Station headStation = StationA;
        private final static Station tailStation = StationF;

        private final int value;
        private final int distance;
        private final TrainStation station;

        /**
         * Constructor for Station
         *
         * @param station               value
         * @param distanceToNextStation
         */
        private Station(int v, int distanceToNext) {
            value = v;
            distance = distanceToNext;
            station = new TrainStation(this);
        }

        /**
         * @return the station's value
         */
        public int getValue() {
            return value;
        }

        /**
         * @return distance to next station
         */
        public int getDistanceToNext() {
            return distance;
        }

        /**
         * @return distance to previous station
         */
        public int getDistanceToPrevious() {
            return getPreviousStation().getDistanceToNext();
        }

        /**
         * @return station object
         */
        public TrainStation getStation() {
            return station;
        }

        /**
         * @return the next station in the route
         */
        public Station getNextStation() {
            for (Station s : Station.values()) {
                if (s.value == value + 1) {
                    return s;
                }
            }
            return headStation;
        }

        /**
         * @return the previous station in the route
         */
        public Station getPreviousStation() {
            for (Station s : Station.values()) {
                if (s.value == value - 1) {
                    return s;
                }
            }
            return tailStation;
        }
    }

    ;
}
