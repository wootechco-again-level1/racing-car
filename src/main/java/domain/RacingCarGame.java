package domain;

import util.NumberGenerator;

public class RacingCarGame {
    private static final int ZERO = 0;

    public static RoundsResult play(Cars cars, int numberOfRound, NumberGenerator numberGenerator) {
        RoundsResult roundsResult = new RoundsResult();
        while (numberOfRound-- > ZERO) {
            OneRound oneRound = cars.playOneRound(numberGenerator);
            roundsResult.addOneRound(oneRound);
        }
        return roundsResult;
    }
}
