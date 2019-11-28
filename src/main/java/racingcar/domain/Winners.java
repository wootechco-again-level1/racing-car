package racingcar.domain;

import racingcar.exception.WinnerNotFoundException;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 우승차를 만드는 객체.
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-27
 */
public class Winners implements Iterable<Car> {
    private final int winnerCount;
    private final Cars cars;

    public Winners(final Cars cars) {
        this.winnerCount = generateWinnerCount(cars);
        this.cars = Cars.of(generateWinners(cars));
    }

    private int generateWinnerCount(Cars cars) {
        return cars.stream()
            .mapToInt(Car::getForwardCount)
            .max().orElseThrow(WinnerNotFoundException::new);
    }

    private Car[] generateWinners(Cars cars) {
        return cars.stream()
            .filter(car -> car.isSameCount(winnerCount))
            .toArray(Car[]::new);
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    @Override
    public void forEach(Consumer<? super Car> action) {
        cars.forEach(action);
    }

    @Override
    public Spliterator<Car> spliterator() {
        return cars.spliterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Winners winners = (Winners) o;

        return Objects.equals(cars, winners.cars);
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }
}
