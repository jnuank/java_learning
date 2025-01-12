package gossipBus;

public class Driver {
    private String nextStop = "stop1";

    public String getStop() {
        return nextStop;
    }

    public void drive() {
        if(nextStop.equals("stop2")){
            nextStop = "stop1";
        }else {
            nextStop = "stop2";
        }
    }
}
