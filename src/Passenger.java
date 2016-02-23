
public class Passenger {
	private Train.Direction passengerDirection;
	private TrainRoute.Station destination;

	public Passenger(TrainRoute.Station dest, Train.Direction dir) {
		destination = dest;
		passengerDirection = dir;
	}

	public Train.Direction getDirection() {
		return passengerDirection;
	}

	public TrainRoute.Station getDestination() {
		return destination;
	}
}
