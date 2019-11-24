package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(Cars cars) {
        this.winners = initWinners(cars);
    }

    private List<Car> initWinners(Cars cars) {
        return cars.getMaxPositionCars();
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
