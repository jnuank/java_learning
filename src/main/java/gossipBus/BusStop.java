package gossipBus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusStop {

    private List<Driver> drivers = new ArrayList<Driver>();

    public BusStop() {

    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    public void gossip() {
        Set<Rumor> rumorsAtStop = new HashSet<>();
        for (Driver d : drivers) {
            rumorsAtStop.addAll(d.getRumors());
        }

        for (Driver d : drivers) {
            d.addRumors(rumorsAtStop);
        }

    }
}
