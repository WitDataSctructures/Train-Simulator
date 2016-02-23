import java.util.ArrayList;

public class TrainRoute {

	public static void main(String[] args) {
		// Create trains
		ArrayList<Train> trains = new ArrayList<Train>();
		trains.add(new Train(Train.Direction.OUTBOUND, 3, Station.StationF));
		trains.add(new Train(Train.Direction.INBOUND, 3, Station.StationA));

		// Create the train route
		new TrainRoute(trains);
	}

	public TrainRoute(ArrayList<Train> trains) {
		// Update loop
		boolean update = true;
		int numberOfUpdates = 6;
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

	public enum Station {
		StationA(0, 1), StationB(1, 2), StationC(2, 3), StationD(3, 4), StationE(4, 3), StationF(5, 2);

		private final static Station headStation = StationA;
		private final static Station tailStation = StationF;

		private final int value;
		private final int distance;
		private final TrainStation station;

		private Station(int v, int distanceToNext) {
			value = v;
			distance = distanceToNext;
			station = new TrainStation(this);
		}

		public int getValue() {
			return value;
		}

		public int getDistanceToNext() {
			return distance;
		}

		public int getDistanceToPrevious() {
			return getPreviousStation().getDistanceToNext();
		}

		public TrainStation getStation() {
			return station;
		}

		public Station getNextStation() {
			for (Station s : Station.values()) {
				if (s.value == value + 1) {
					return s;
				}
			}
			return headStation;
		}

		public Station getPreviousStation() {
			for (Station s : Station.values()) {
				if (s.value == value - 1) {
					return s;
				}
			}
			return tailStation;
		}
	};
}
