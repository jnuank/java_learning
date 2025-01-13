package gossipBus;

import java.util.Collection;
import java.util.Set;

public class Driver {
    private String nextStop = "stop1";
    private Route route;
    private int stopNumber = 0;
    private Set<Rumor> rumors;

    public Driver(Route route, Rumor... rumors) {
        this.route = route;
        this.rumors = Set.of(rumors);
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

    public Set<Rumor> getRumors() {
        return rumors;
    }
}
