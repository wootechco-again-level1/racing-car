package domain;

import util.NumberGenerator;

import java.util.Collections;
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

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .get();
    }
}
