package Application.Tests;

import Application.Train;
import Application.TrainRoute;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Mark on 10/31/2016.
 */
public class EndToEndTests {
    @Test
    public void RunSim() {
        ArrayList<Train> trains = new ArrayList<Train>();
        Train t1 = new Train(Train.Direction.OUTBOUND, 3, TrainRoute.Station.StationF);
        Train t2 = new Train(Train.Direction.OUTBOUND, 4, TrainRoute.Station.StationD);
        Train t3 = new Train(Train.Direction.INBOUND, 3, TrainRoute.Station.StationA);
        Train t4 = new Train(Train.Direction.INBOUND, 4, TrainRoute.Station.StationD);
        trains.add(t1);
        trains.add(t2);
        trains.add(t3);
        trains.add(t4);
        // Create the train route
        TrainRoute tr = new TrainRoute(trains);
        int[] after = new int[]{1, 1, 1, 1};
        int[] before = new int[]{0, 0, 0, 0};
        Assert.assertArrayEquals(before, new int[]{t1.getDistanceToStation(), t2.getDistanceToStation(),
                t3.getDistanceToStation(), t4.getDistanceToStation()});
        tr.runSimulation(20);
        Assert.assertArrayEquals(after, new int[]{t1.getDistanceToStation(), t2.getDistanceToStation(),
                t3.getDistanceToStation(), t4.getDistanceToStation()});

    }

}
