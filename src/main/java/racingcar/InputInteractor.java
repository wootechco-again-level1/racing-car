package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputInteractor {
    private static final String CAR_NAME_DELIMITER = ",";
    private final InputView inputView;

    public InputInteractor(InputView inputView) {
        this.inputView = inputView;
    }

    public RacingGame readyForGame() {
        final Cars cars = generateCars(inputView.inputCarNames());
        final int numberOfRound = roundOfNumber();

        return new RacingGame(cars, numberOfRound);
    }

    private Cars generateCars(String carNames) {
        List<Car> cars = Stream.of(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private int roundOfNumber() {
        return inputView.inputNumberOfRound();
    }
}
