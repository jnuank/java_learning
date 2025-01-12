package gossipBus;

public class Driver {
    private String nextStop = "stop1";

    public String getStop() {
        return nextStop;
    }

    public void drive() {
        nextStop = "stop2";
    }
}
