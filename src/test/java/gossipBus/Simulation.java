package gossipBus;

import java.util.HashSet;
import java.util.Set;

public class Simulation {
    public static int driveTillEqual(Driver... drivers) {
        int time;
        for (time = 0; notAllRumors(drivers) && time < 480; time++) {
            driveAndGossip(drivers);
        }
        return time;
    }

    private static void driveAndGossip(Driver[] drivers) {
        Set<BusStop> stops = new HashSet<>();
        for (Driver d : drivers) {
            d.drive();
            stops.add(d.getStop());
        }
        for (BusStop stop : stops) {
            stop.gossip();
        }
    }

    private static boolean notAllRumors(Driver[] drivers) {
        Set<Rumor> allRumors = new HashSet<>();
        for (Driver d : drivers) {
            allRumors.addAll(d.getRumors());
        }
        for (Driver d : drivers) {
            if (!d.getRumors().equals(allRumors)) {
                return true;
            }
        }
        return false;
    }
}
