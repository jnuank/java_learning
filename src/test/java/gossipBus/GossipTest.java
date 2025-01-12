package gossipBus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GossipTest {
    @Test
    public void ドライバーが最初に止まるバス停はstop1() {
        var driver1 = new Driver();
        assertEquals("stop1", driver1.getStop());
    }

    @Test
    public void ドライバーが2番目に止まるバス停はstop2() {
        var driver1 = new Driver();
        driver1.drive(); // 何も返さないのって気持ち悪いなぁ
        assertEquals("stop2", driver1.getStop());
    }
}
