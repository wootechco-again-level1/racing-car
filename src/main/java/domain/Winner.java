package domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Winner {
    private static final int WINNER_COUNT = 0;

    private final Cars cars;

    public Winner(final Cars cars, final int maxDistance) {
        this.cars = findWinner(cars, maxDistance);
    }

    private Cars findWinner(final Cars cars, final int maxDistance) {
        return new Cars(cars.stream()
                .filter(car -> car.isMaxDistance(maxDistance))
                .collect(Collectors.toList())
        );
    }

    public boolean hasNotWinner() {
        return !(cars.getSize() > WINNER_COUNT);
    }

    public int getSize() {
        return cars.getSize();
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    @Override
    public String toString() {
        return "Winner{" + "cars=" + cars + '}';
    }
}
