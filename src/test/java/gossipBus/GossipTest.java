package gossipBus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GossipTest {
    private Driver driver1;
    private Driver driver2;

    @BeforeEach
    public void setUp() {
        driver1 = new Driver();
        driver2 = new Driver();
    }
    @Test
    public void ドライバーが最初に止まるバス停はstop1() {
        assertEquals("stop1", driver1.getStop());
    }

    @Test
    public void ドライバーが2番目に止まるバス停はstop2() {
        driver1.drive(); // 何も返さないのって気持ち悪いなぁ
        assertEquals("stop2", driver1.getStop());
    }

    @Test
    public void ドライバーが最後に止まるバス停はstop1() {
        driver1.drive();
        driver1.drive();
        assertEquals("stop1", driver1.getStop());
    }

    @Test
    public void バス停1にいるドライバーが2人いる() {
        var stop1 = new BusStop();
        stop1.addDriver(driver1);
        stop1.addDriver(driver2);
        assertEquals(List.of(driver1, driver2), stop1.getDrivers());
    }

    @Test
    public void バス停2にいるドライバーはいない() {
        var stop2 = new BusStop();

        assertEquals(Collections.emptyList(), stop2.getDrivers());
    }
}
