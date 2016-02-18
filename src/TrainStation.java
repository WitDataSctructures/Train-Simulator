import java.util.Random;

public class TrainStation {

	private static final int PEOPLE_MAX = 10;

	@SuppressWarnings("unused")
	private String stationName;
	private Random random;
	private QueueOfPassengers inboundQueue, outboundQueue;

	public TrainStation(String stationName) {
		this.stationName = stationName;
		random = new Random();
	}

	public void update() {
		generatePassengers();
	}

	private void generatePassengers() {
		// Determine how many passengers to add to the platform
		int newPassengers = random.nextInt(PEOPLE_MAX);

		for (int i = 0; i < newPassengers; i++) {

		}
	}

	private int getNumberOfStations() {
		return TrainRoute.Station.values().length;
	}
}
