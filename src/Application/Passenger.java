/**
 * Comp 2071
 * Lab 03: Queues
 * Due: February 23rd, 2016
 * Group #: 15
 * <p>
 * A passenger class
 *
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */
package Application;

public class Passenger {
    private TrainRoute.Station destination;

    /**
     * Sets the destination of the Passenger
     * @param destination
     */
    public Passenger(TrainRoute.Station dest) {
        destination = dest;
    }

    /**
     * @return the passenger's destination
     */
    public TrainRoute.Station getDestination() {
        return destination;
    }
}
