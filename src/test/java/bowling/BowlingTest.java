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

    private void rollMany(int pins, int n) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void スコア計算する() {
        rollMany(0, 20);

        assertEquals(0, game.score());
    }

    @Test
    public void すべて1ピンずつ倒した場合は20() {
        rollMany(1, 20);

        assertEquals(20, game.score());
    }

    @Test
    public void ワンスペアを取った場合() {
        rollMany(5, 2);
        game.roll(7);
        rollMany(0, 17);

        assertEquals(24, game.score());
    }

}
