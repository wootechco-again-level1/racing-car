package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public GameResult generateGameResult() {
        List<MovedCar> movedCars = cars.getAllCars()
                .stream()
                .map(MovedCar::new)
                .collect(Collectors.toList());

        return new GameResult(movedCars);
    }
}
