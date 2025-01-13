package gossipBus;

public class Route {

    private BusStop[] stops;

    public Route (BusStop... busStop) {
        this.stops = busStop;
    }

    public void leave(Driver driver, int stopNumber) {
        stops[stopNumber].removeDriver(driver);
    }

    public int getNextStop(int stopNumber) {
        return (stopNumber + 1) % stops.length;
    }

    public void stopAt(Driver driver, int stopNumber) {
        stops[stopNumber].addDriver(driver);
    }
}
