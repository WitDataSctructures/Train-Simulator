
public class Passenger {
	private TrainRoute.Station destination;
	
	public Passenger(TrainRoute.Station dest, Train.Direction dir){
		destination = dest;
	}
	
	public TrainRoute.Station getDestination(){
		return destination;
	}
}
