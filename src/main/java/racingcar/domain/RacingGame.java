package racingcar.domain;

import racingcar.utils.MovableGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RoundResults startGame(int numberOfRound) {
        List<RoundResult> roundResults = IntStream.rangeClosed(1, numberOfRound)
                .mapToObj(i -> cars.round(MovableGenerator.generate(cars)))
                .collect(Collectors.toList());

        return new RoundResults(roundResults);
    }

    public GameResult generateGameResult() {
        List<MovedCar> movedCars = cars.getAllCars()
                .stream()
                .map(MovedCar::new)
                .collect(Collectors.toList());

        return new GameResult(movedCars);
    }
}
