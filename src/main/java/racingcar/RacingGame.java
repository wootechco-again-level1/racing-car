package racingcar;

import racingcar.domain.Cars;

import java.util.stream.IntStream;

public class RacingGame {

    private final Cars cars;
    private final int round;

    public RacingGame(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        IntStream.rangeClosed(1, round).forEach(i -> cars.execute(new RandomMove()));
    }
}