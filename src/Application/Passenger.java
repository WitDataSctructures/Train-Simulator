package Application;

public class Passenger {
	private TrainRoute.Station destination;

	public Passenger(TrainRoute.Station dest) {
		destination = dest;
	}

	public TrainRoute.Station getDestination() {
		return destination;
	}
}
