package bowling;

public class Game {
//    private int score = 0;
    private final int[] rolls = new int[20];
    private int frameIndex = 0;

    public void roll(int pins) {
        rolls[frameIndex] = pins;
        frameIndex++;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(frameIndex)){
                return 24;
            } else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
}
