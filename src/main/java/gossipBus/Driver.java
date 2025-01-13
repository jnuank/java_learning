package gossipBus;

public class Driver {
    private String nextStop = "stop1";
    private Route route;
    private int stopNumber = 0;

    public Driver(Route route) {
        this.route = route;
    }

    public String getStop() {
        return nextStop;
    }

    public void drive() {
        route.leave(this, stopNumber);
        stopNumber = route.getNextStop(stopNumber);
        route.stopAt(this, stopNumber);
        if(nextStop.equals("stop2")){
            nextStop = "stop1";
        }else {
            nextStop = "stop2";
        }
    }
}
