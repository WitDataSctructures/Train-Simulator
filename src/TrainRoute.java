
public class TrainRoute {

	public static void main(String[] args) {
		new TrainRoute();
	}

	public TrainRoute() {

	}

	public static enum Station {
		StationA, StationB, StationC, StationD, StationE, StationF;

		public static int getDistanceToNext(Station s) {
			int distance = 0;
			switch (s) {
				case StationA:
					distance = 1;
					break;
				case StationB:
					distance = 2;
					break;
				case StationC:
					distance = 3;
					break;
				case StationD:
					distance = 4;
					break;
				case StationE:
					distance = 3;
					break;
				case StationF:
					distance = 2;
					break;
				default:
					System.out.println("Station not added to getDistanceToNext method");
					break;

			}
			return distance;
		}

		public static Station getNextStationFrom(Station s) {
			return StationA;
		}
	};

}
