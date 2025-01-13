package gossipBus;

public class Driver {
    private String nextStop = "stop1";
    private Route route;

    public Driver(Route route) {
        this.route = route;
    }

    public String getStop() {
        return nextStop;
    }

    public void drive() {
        route.leave(this);
        if(nextStop.equals("stop2")){
            nextStop = "stop1";
        }else {
            nextStop = "stop2";
        }
    }
}
