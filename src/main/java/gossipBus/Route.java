package gossipBus;

public class Route {

    private BusStop busStop;

    public Route (BusStop busStop) {
        this.busStop = busStop;
    }

    public void leave(Driver driver) {
        busStop.removeDriver(driver);
    }
}
