package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.result.RoundResult;
import racingcar.result.Winners;

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

    public boolean isFinished() {
        return round.isFinished();
    }

    public RoundResult getRoundResult() {
        return roundResult;
    }

    public Winners getWinners() {
        return new Winners(cars);
    }
}