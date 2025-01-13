package gossipBus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

public class GossipTest {
    private Driver driver1;
    private Driver driver2;
    private BusStop stop1;
    private BusStop stop2;
    private BusStop stop3;
    private Route route1;
    private Route route2;

    @BeforeEach
    public void setUp() {
        stop1 = new BusStop();
        stop2 = new BusStop();
        stop3 = new BusStop();

        route1 = new Route(stop1, stop2);
        route2 = new Route(stop1, stop2, stop3);
        driver1 = new Driver(route1);
        driver2 = new Driver(route2);

        stop1.addDriver(driver1);
        stop1.addDriver(driver2);
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
        assertTrue(List.of(driver1, driver2).containsAll(stop1.getDrivers()));
    }

    @Test
    public void バス停2にいるドライバーはいない() {
        var stop2 = new BusStop();

        assertEquals(emptyList(), stop2.getDrivers());
    }

    @Test
    public void 複数のドライバーがバス停に停まったり出発したりする() {
        // 初期状態
        assertDriversOnBusStop(stop1, List.of(driver1, driver2));
        assertEquals(emptyList(), stop2.getDrivers());
        assertEquals(emptyList(), stop3.getDrivers());

        // driver1とdriver2が移動
        driver1.drive();
        driver2.drive();
        assertEquals(emptyList(), stop1.getDrivers());
        assertDriversOnBusStop(stop2, List.of(driver1, driver2));
        assertEquals(emptyList(), stop3.getDrivers());

        // driver1とdriver2が移動
        driver1.drive();
        driver2.drive();
        assertDriversOnBusStop(stop1, List.of(driver1));


    }

    private void assertDriversOnBusStop(BusStop stop, List<Driver> drivers) {
        assertNotEquals(emptyList(), stop.getDrivers());
        for (var driver : drivers) {
            assertTrue(stop.getDrivers().contains(driver), "not contain: %s".formatted(driver));
        }
    }
}
