package racingcar.domain;

import racingcar.exception.IllegalCarNameException;
import strategy.MoveStrategy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Car 객체들을 가지고 있는 객체
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
public class Cars implements Iterable<Car> {
    private static final String NAME_DUPLICATE_EXCEPTION_MESSAGE = "중복되는 이름은 사용할 수 없습니다.";

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNames(cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList()));
        this.cars = cars;
    }

    public Cars(final List<String> names, final MoveStrategy moveStrategy) {
        validateNames(names);
        this.cars = names.stream()
            .map(name -> new Car(name, moveStrategy))
            .collect(Collectors.toList());
    }

    private void validateNames(final List<String> names) {
        long distinctSize = names.stream().distinct().count();
        if (names.size() != distinctSize) {
            throw new IllegalCarNameException(NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public static Cars of(final Car... cars) {
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

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public void forEach(Consumer<? super Car> action) {
        cars.forEach(action);
    }

    @Override
    public Spliterator<Car> spliterator() {
        return cars.spliterator();
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
