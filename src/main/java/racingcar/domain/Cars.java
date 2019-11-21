package racingcar.domain;

import java.util.Arrays;
import java.util.List;
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

    public Cars(final List<String> names, final RaceCount raceCount, final IntPredicate determineMovement) {
        this.cars = names.stream()
            .map(name -> new Car(name, raceCount, determineMovement))
            .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(Car... cars) {
        return new Cars(Arrays.asList(cars));
    }

    public int size() {
        return cars.size();
    }
}
