package domain;

import util.NumberGenerator;

public class RacingCarGame {
    private static final int ZERO = 0;

    public static RoundsResult play(Cars cars, int countOfGame, NumberGenerator numberGenerator) {
        RoundsResult roundsResult = new RoundsResult();
        while (countOfGame-- > ZERO) {
            OneRound oneRound = cars.playOneRound(numberGenerator);
            roundsResult.addOneRound(oneRound);
        }
        return roundsResult;
    }
}
