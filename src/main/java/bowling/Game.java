package bowling;

public class Game {
    private int score = 0;

    public void roll(int i) {
        score += i;

    }

    public int score() {
        return score;
    }
}
