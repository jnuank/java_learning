package gossipBus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GossipTest {
    private Driver driver1;

    @BeforeEach
    public void setUp() {
        driver1 = new Driver();
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
}
