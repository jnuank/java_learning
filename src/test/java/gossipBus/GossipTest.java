package gossipBus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Rumor rumor1;
    private Rumor rumor2;
    private Rumor rumor3;

    @BeforeEach
    public void setUp() {
        rumor1 = new Rumor("rumor1");
        rumor2 = new Rumor("rumor2");
        rumor3 = new Rumor("rumor3");

        stop1 = new BusStop();
        stop2 = new BusStop();
        stop3 = new BusStop();

        route1 = new Route(stop1, stop2);
        route2 = new Route(stop1, stop2, stop3);
        driver1 = new Driver(route1, rumor1);
        driver2 = new Driver(route2, rumor2, rumor3);

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
        assertEquals(emptyList(), stop2.getDrivers());
        assertDriversOnBusStop(stop3, List.of(driver2));

        // 最後
        driver1.drive();
        driver2.drive();
        assertDriversOnBusStop(stop1, List.of(driver2));
        assertDriversOnBusStop(stop2, List.of(driver1));
        assertEquals(emptyList(), stop3.getDrivers());

    }

    private void assertDriversOnBusStop(BusStop stop, List<Driver> drivers) {
        assertEquals(new HashSet<>(stop.getDrivers()), new HashSet<>(drivers));
    }

    private void asserDriverHasRumors(Driver driver, Set<Rumor> rumors) {
        assertEquals(rumors, driver.getRumors());
    }

    @Test
    public void 運転前のドライバーが持っている噂話() {
        assertTrue(driver1.getRumors().contains(rumor1));
        asserDriverHasRumors(driver2, Set.of(rumor3, rumor2));
    }

    @Test
    public void バス停に誰もいない時は噂話はない() {
        stop2.gossip();
        assertTrue(driver1.getRumors().contains(rumor1));
        asserDriverHasRumors(driver2, Set.of(rumor3, rumor2));
    }

    @Test
    public void バス停1にいるドライバーたちが噂話をする() {
        stop1.gossip();
        asserDriverHasRumors(driver1, Set.of(rumor1, rumor3, rumor2));
        asserDriverHasRumors(driver2, Set.of(rumor1, rumor3, rumor2));
    }

}
