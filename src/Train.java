import java.util.ArrayList;

public class Train {
	public static enum Direction{
		INBOUND, OUTBOUND
	}
	
	public static final int PASS_PER_CAR = 12;
	private int carsInTrain;
	private int distanceToStation;
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>(); 
	private Direction directionOfTravel;
	private TrainRoute.Station currentStation;
	private TrainRoute.Station nextStation;
	
	public Train(Direction dir, int numOfCars){
		directionOfTravel = dir;
		carsInTrain = numOfCars;
	}
	
	public int getNumberOfCars(){
		return carsInTrain;
	}
	
	public void addCar(){
		carsInTrain++;
	}
	
	public void update(){
		if (distanceToStation == 0){
			if (directionOfTravel == Direction.INBOUND){
				nextStation = currentStation.getNextStation();
				distanceToStation = currentStation.getDistanceToNext();
			}else{
				nextStation = currentStation.getPreviousStation();
				distanceToStation = currentStation.getDistanceToPrevious();
			}
		} else {
			distanceToStation--;
		}
	}
	
	public Direction getDirection(){
		return directionOfTravel;
	}
}
