
public class Passenger {
	public static enum Direction{
		INBOUND, OUTBOUND
	}
	
	private Direction passengerDirection;
	private Station destination;
	
	public Passenger(Station dest, Direction dir){
		destination = dest;
		passengerDirection = dir;
	}
	
	public Direction getDirection(){
		return passengerDirection;
	}
	public Station getDestination(){
		return destination;
	}
}
