package domain;

import domain.exception.DuplicateNameException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        checkDuplicate(cars);
        this.cars = cars;
    }

    private void checkDuplicate(final List<Car> cars) {
        if (cars.size() == new HashSet<>(cars).size()) {
            return;
        }

        throw new DuplicateNameException();
    }

    public Cars move(final MoveStrategy moveStrategy) {
        return new Cars(cars.stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList())
        );
    }

    public int getSize() {
        return cars.size();
    }

    public Car get(final int index) {
        return cars.get(index);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    @Override
    public String toString() {
        return "Cars{" + "list=" + cars + '}';
    }
}
