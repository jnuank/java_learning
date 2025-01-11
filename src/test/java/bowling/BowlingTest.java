package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {
    private Game game;
    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void スコア計算する() {
        for (int i=0; i<20; i++) {
            game.roll(0);
        }

        assertEquals(0, game.score());
    }

    @Test
    public void すべて1ピンずつ倒した場合は20() {

        for (int i=0; i<20; i++) {
            game.roll(1);
        }

        assertEquals(20, game.score());
    }
}
