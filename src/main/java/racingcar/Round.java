package racingcar;

public class Round {

    private static final int CURRENT_ROUND = 0;

    private final int totalRound;
    private int curRound;

    public Round(int totalRound) {
        this.totalRound = totalRound;
        this.curRound = CURRENT_ROUND;
    }

    public void next() {
        curRound++;
    }

    public boolean isFinished() {
        return totalRound == curRound;
    }
}
