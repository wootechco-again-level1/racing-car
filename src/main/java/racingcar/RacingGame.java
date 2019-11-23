package racingcar;

import racingcar.domain.Cars;
import racingcar.result.Winners;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {

    private final Cars cars;
    private final int round;
    private Winners winners;

    public RacingGame(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        IntStream.rangeClosed(1, round).forEach(i -> cars.execute(new RandomMove()));
        this.winners = new Winners(cars);
    }

    public List<String> getWinners() {
        return winners.getWinnerNames();
    }
}