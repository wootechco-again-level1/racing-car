package racingcar.domain;

import racingcar.controller.MoveStrategy;
import racingcar.exception.PositionCompareException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private static final String SPACE_NAME = " ";
    private static final String NON_SPACE_NAME = "";
    private static final String NAME_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = initCars(carNames);
    }

    private List<Car> initCars(String carNames) {
        return parsedCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private List<String> parsedCarNames(String carNames) {
        return Arrays.asList(carNames.replaceAll(SPACE_NAME, NON_SPACE_NAME).split(NAME_DELIMITER));
    }

    public void execute(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy.isMove()));
    }

    public List<Car> getMaxPositionCars() {
        int maxCarPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.matchPosition(maxCarPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(PositionCompareException::new);
    }

    public Map<String, Integer> getPositions() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
