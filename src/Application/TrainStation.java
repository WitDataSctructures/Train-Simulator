package Application;
import java.util.Random;

import ADT.QueueOfPassengers;

public class TrainStation {

	private static final int PEOPLE_MAX = 10;

	private TrainRoute.Station stationEnum;
	private Random random;
	public QueueOfPassengers inboundQueue, outboundQueue;

	public TrainStation(TrainRoute.Station station) {
		this.stationEnum = station;
		random = new Random();
		inboundQueue = new QueueOfPassengers();
		outboundQueue = new QueueOfPassengers();
	}

	public void update() {
		// System.out.println("Generating Passenger for Station: " +
		// stationEnum.toString());
		generatePassengers();
	}

	private void generatePassengers() {
		// Determine how many passengers to add to the platform
		int newPassengers = random.nextInt(PEOPLE_MAX);
		int numberOfStations = TrainRoute.Station.values().length;
		for (int i = 0; i < newPassengers; i++) {
			TrainRoute.Station start = stationEnum;
			// Pick a station to go to
			int stationNumber = random.nextInt(numberOfStations);
			TrainRoute.Station end = TrainRoute.Station.values()[stationNumber];
			// Make sure it is a different station
			if (start == end) {
				end = end.getNextStation();
			}
			// Create the passenger
			Train.Direction direction = getDirection(start, end);
			Passenger passenger = new Passenger(end);
			// Put the passenger in line for the correct train
			if (direction.equals(Train.Direction.OUTBOUND)) {
				// System.out.println(" Passenger going OUTBOUND to " +
				// end.toString());
				outboundQueue.enqueue(passenger);
			} else {
				// System.out.println(" Passenger going INBOUND to " +
				// end.toString());
				inboundQueue.enqueue(passenger);
			}
		}
	}

	private static Train.Direction getDirection(TrainRoute.Station start, TrainRoute.Station end) {
		TrainRoute.Station s = start;
		int distanceNext = 0;
		int distancePrev = 0;
		while (s != end) {
			distanceNext += s.getDistanceToNext();
			s = s.getNextStation();
		}
		s = start;
		while (s != end) {
			distancePrev += s.getDistanceToPrevious();
			s = s.getPreviousStation();
		}
		if (distanceNext <= distancePrev) {
			return Train.Direction.INBOUND;
		}
		return Train.Direction.OUTBOUND;
	}
}
