package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public RoundResult round(List<Integer> movable) {
        List<MovedCar> movedCars = new ArrayList<>();

        for (int i = 0; i < numberOfCars(); i++) {
            Car car = cars.get(i);
            car.move(movable.get(i));
            movedCars.add(new MovedCar(car));
        }

        return new RoundResult(movedCars);
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int numberOfCars() {
        return cars.size();
    }
}