package domain;

import util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public OneRound playOneRound(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.race(numberGenerator);
        }
        Map<String, Integer> carStatuses = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
        return new OneRound(carStatuses);
    }

    public Winners getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return new Winners(winners);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }
}
