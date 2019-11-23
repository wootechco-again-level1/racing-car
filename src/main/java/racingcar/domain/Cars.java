package racingcar.domain;

import racingcar.exception.PositionCompareException;
import racingcar.service.MoveStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = initCars(carNames);
    }

    private List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void execute(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy.isMove()));
    }

    public List<Car> getMaxPositionCars() {
        int maxCarPosition = getMaxCarPosition();

        return cars.stream()
                .filter(car -> car.matchPosition(maxCarPosition))
                .collect(Collectors.toList());
    }

    private int getMaxCarPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(PositionCompareException::new);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
