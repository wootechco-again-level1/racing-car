package racingcar.domain;

import racingcar.exception.WinnerNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Car 객체들을 가지고 있는 객체
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(final List<String> names, final IntPredicate determineMovement) {
        this.cars = names.stream()
            .map(name -> new Car(name, determineMovement))
            .collect(Collectors.toList());
    }

    public static Cars of(Car... cars) {
        return new Cars(Arrays.asList(cars));
    }

    /**
     * 레이스를 진행.
     */
    public void race() {
        cars.forEach(Car::race);
    }

    /**
     * 현재 가장 많이 이동한 자동차들을 리턴.
     *
     * @return
     */
    public Cars generateWinner() {
        int winnerCount = cars.stream()
            .mapToInt(Car::getForwardCount)
            .max().orElseThrow(WinnerNotFoundException::new);
        Car[] winners = cars.stream()
            .filter(car -> car.isSameCount(winnerCount))
            .toArray(Car[]::new);
        return Cars.of(winners);
    }

    public int size() {
        return cars.size();
    }

    public void forEach(Consumer<? super Car> action) {
        cars.forEach(action);
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    @Override
    public String toString() {
        return "Cars{" +
            "cars=" + cars +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars cars1 = (Cars) o;

        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }
}
