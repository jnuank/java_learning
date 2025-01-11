package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingTest {
    private Game game;
    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void Rollする() {
        game.roll(0);
    }
}
