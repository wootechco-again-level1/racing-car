package racingcar.domain;

public class Round {

    private final int totalRound;
    private int round;

    public Round(int totalRound) {
        this.totalRound = totalRound;
        this.round = 1;
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
