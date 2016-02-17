
public class TrainRoute {

	public static void main(String[] args) {
		new TrainRoute();
		System.out.println(Station.StationF.getNextStation());
	}

	public TrainRoute() {
		// Update loop
		while (true) {
			// Update stations
			for (Station station : Station.values()) {
				station.getStation().update();
			}

			// Update train

		}
	}

	public enum Station {
		StationA(0, 1), StationB(1, 2), StationC(2, 3), StationD(3, 4), StationE(4, 3), StationF(5, 2);

		private final static Station headStation = StationA;

		private final int value;
		private final int distance;
		private final TrainStation station;

		private Station(int v, int distanceToNext) {
			value = v;
			distance = distanceToNext;
			station = new TrainStation(this.name());
		}

		public int getValue() {
			return value;
		}

		public int getDistanceToNext() {
			return distance;
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
	};
}
