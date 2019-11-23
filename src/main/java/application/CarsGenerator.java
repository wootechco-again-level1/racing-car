package application;

import domain.Car;
import domain.Cars;
import utils.InputUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CarsGenerator {
    private static final int INITIAL_POSITION = 0;

    public static Cars generate(final String name) {
        return new Cars(
                Arrays.stream(InputUtils.splitWithCommaAndRemoveBlank(name))
                        .map(carName -> new Car(carName, INITIAL_POSITION))
                        .collect(Collectors.toList())
        );
    }
}