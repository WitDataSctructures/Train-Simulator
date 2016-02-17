
public class TrainRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TrainRoute() {

	}

	public enum Station {
		StationA, StationB, StationC, StationD, StationE, StationF;

		public int getDistanceToNext(Station s) {
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
	};

}
