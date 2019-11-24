package racingcar.domain;

public class Round {

    private static final int START_ROUND = 1;

    private final int totalRound;
    private int round;

    public Round(int totalRound) {
        this.totalRound = totalRound;
        this.round = START_ROUND;
    }

    public void next() {
        round++;
    }

    public boolean isFinished() {
        return round == totalRound;
    }

    public int getRound() {
        return round;
    }
}
