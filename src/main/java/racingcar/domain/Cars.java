package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

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

    public Cars(final List<String> names, final int raceCount, final IntPredicate determineMovement) {
        this.cars = names.stream()
            .map(name -> new Car(name, raceCount, determineMovement))
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

    public int size() {
        return cars.size();
    }

    public void forEach(Consumer<? super Car> action) {
        cars.forEach(action);
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
