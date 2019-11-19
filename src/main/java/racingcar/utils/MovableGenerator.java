package racingcar.utils;

import racingcar.domain.Cars;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MovableGenerator {
    private static final int MOVABLE_MAX_BOUND = 10;

    public static List<Integer> generate(Cars cars) {
        Random random = new Random();
        final int numberOfCar = cars.count();

        return IntStream.rangeClosed(1, numberOfCar)
                .mapToObj(i -> random.nextInt(MOVABLE_MAX_BOUND))
                .collect(Collectors.toList());
    }
}