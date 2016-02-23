
public class Passenger {
	private TrainRoute.Station destination;
	private Train.Direction passengerDirection;

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
