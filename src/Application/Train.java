package Application;

import java.util.ArrayList;

/**
 * Comp 2071
 * Lab 03: Queues
 * Due: February 23rd, 2016
 * Group #: 15
 * <p>
 * A class to represnt a Train
 *
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

public class Train {
    public static final int PASS_PER_CAR = 12;
    private int capacity = 0;
    private int carsInTrain;
    private int distanceToStation;
    private ArrayList<Passenger> passengers;
    private Direction directionOfTravel;
    private TrainRoute.Station nextStation;
    /**
     * Train Constructor
     *
     * @param dir             direction train is going in
     * @param numOfCars       in the train
     * @param startingStation
     */
    public Train(Direction dir, int numOfCars, TrainRoute.Station startingStation) {
        directionOfTravel = dir;
        carsInTrain = numOfCars;
        capacity = PASS_PER_CAR * carsInTrain;
        this.passengers = new ArrayList<>();
        // Put train at random station
        nextStation = startingStation;
    }

    /**
     * @return number of cars in the train
     */
    public int getNumberOfCars() {
        return carsInTrain;
    }

    /**
     * Adds a car to the train
     */
    public void addCar() {
        carsInTrain++;
        capacity = PASS_PER_CAR * carsInTrain;
    }

    /**
     * Moves the train, loads and unloads passengers
     */
    public void update() {
        System.out.println(this.toString());
        // If not at station keep moving
        if (distanceToStation > 0) {
            distanceToStation--;
        } else {
            // Unload passengers
            for (int i = passengers.size() - 1; i > 0; i--) {
                if (passengers.get(i).getDestination() == nextStation) {
                    passengers.remove(i);
                }
            }

            // Load passengers and reset station
            if (directionOfTravel == Direction.INBOUND) {
                // Leave if train is full or no more passengers are to be boarded
                while (passengers.size() < capacity && !nextStation.getStation().inboundQueue.isEmpty()) {
                    passengers.add(nextStation.getStation().inboundQueue.dequeue());
                }

                // Set station
                distanceToStation = nextStation.getDistanceToNext();
                nextStation = nextStation.getNextStation();
            } else {
                // Leave if train is full or no more passengers are to be boarded
                while (passengers.size() < capacity && !nextStation.getStation().outboundQueue.isEmpty()) {
                    passengers.add(nextStation.getStation().outboundQueue.dequeue());
                }

                // Set station
                distanceToStation = nextStation.getDistanceToPrevious();
                nextStation = nextStation.getPreviousStation();
            }
        }
    }

    /**
     * @return the direction of the train
     */
    public Direction getDirection() {
        return directionOfTravel;
    }

    /**
     * Gets the distance the train has until it reaches the next station.
     *
     * @return Distance to the next station
     */
    public int getDistanceToStation() {
        return distanceToStation;
    }

    @Override
    public String toString() {
        String out = "";
        out = "Train: " + directionOfTravel + "  Cars = " + carsInTrain;
        out += "\n\tNumber of open seats: " + (capacity - passengers.size());
        out += "\n\tNumber of passengers: " + passengers.size();
        if (distanceToStation > 0) {
            out += "\n\tDistance to " + nextStation + " = " + distanceToStation;
        } else {
            out += ("\n\tCurrently at Station: " + nextStation);
        }
        return out;
    }

    public static enum Direction {
        INBOUND, OUTBOUND
    }
}
