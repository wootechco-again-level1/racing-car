package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.domain.RoundResult;
import racingcar.domain.Winners;

import java.util.List;
import java.util.Map;

public class RacingGame {

    private final Cars cars;
    private final Round round;
    private final RoundResult roundResult;

    public RacingGame(String carNames, int count) {
        this.cars = new Cars(carNames);
        this.round = new Round(count);
        this.roundResult = new RoundResult();
    }

    public void race() {
        cars.execute(new RandomMove());
        roundResult.update(cars);
        round.next();
    }

    public boolean remainRound() {
        return !round.isFinished();
    }

    public Map<String, Integer> getPositions() {
        return roundResult.getPositions();
    }

    public List<String> getWinners() {
        return new Winners(cars).getWinnerNames();
    }
}