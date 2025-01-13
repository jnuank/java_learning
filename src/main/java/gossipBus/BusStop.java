package gossipBus;

import java.util.ArrayList;
import java.util.List;

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
}
