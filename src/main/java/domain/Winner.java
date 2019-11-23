package domain;

import java.util.Objects;
import java.util.stream.Collectors;

public class Winner {
    private static final int WINNER_COUNT = 0;

    private final Cars cars;
    private final int maxDistance;

    public Winner(final Cars cars, final int maxDistance) {
        this.cars = cars;
        this.maxDistance = maxDistance;
    }

    public Cars findWinner() {
        return new Cars(cars.getCars().stream()
                .filter(car -> car.isMaxDistance(maxDistance))
                .collect(Collectors.toList())
        );
    }

    public boolean hasNotWinner() {
        return !(findWinner().getSize() > WINNER_COUNT);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return maxDistance == winner.maxDistance && Objects.equals(cars, winner.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, maxDistance);
    }

    @Override
    public String toString() {
        return "Winner{" + "cars=" + cars + ", maxDistance=" + maxDistance + '}';
    }
}
