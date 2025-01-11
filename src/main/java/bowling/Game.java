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
            if (isStrike(frameIndex)){
                score += 10 + strikeBonus(frameIndex);
                frameIndex ++;
            } else if (isSpare(frameIndex)){
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += twoBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int twoBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + spareBonus(frameIndex);
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return twoBallsInFrame(frameIndex) == 10;
    }
}
