package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.IllegalCarNameException;

import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class CarTest {
    private static final int DEFAULT_RACE_COUNT = 5;

    private Car car;
    private PlayCount defaultPlayCount = new PlayCount(DEFAULT_RACE_COUNT);
    private RaceCount defaultRaceCount = new RaceCount(defaultPlayCount);
    private IntPredicate defaultDeterminationMovement = number -> number >= 4;

    @BeforeEach
    void setUp() {
        car = new Car("car", defaultRaceCount, defaultDeterminationMovement);
    }

    @Test
    void constructor_name() {
        String carName = "first";
        Car car = new Car(carName, defaultRaceCount, defaultDeterminationMovement);
        assertEquals(car.getName(), carName);
    }

    @ParameterizedTest
    @MethodSource("invalidNames")
    void constructor_name_exception(final String invalidName) {
        assertThrows(IllegalCarNameException.class, () -> {
            new Car(invalidName, defaultRaceCount, defaultDeterminationMovement);
        });
    }

    static private Stream<String> invalidNames() {
        return Stream.of("firstC", "", " ", null);
    }

    @Test
    void play_forward() {
        car.move(4);
        assertEquals(car.getForwardCount(), 1);
    }

    @Test
    void play_stop() {
        car.move(3);
        assertEquals(car.getForwardCount(), 0);
    }

    @Test
    void equals() {
        String name = "car";
        Car target = new Car(name, defaultRaceCount, defaultDeterminationMovement);
        Car source = new Car(name, defaultRaceCount, number -> number >= 4);

        assertEquals(target, source);
    }

    @Test
    void equals_move() {
        String name = "car";
        Car target = new Car(name, defaultRaceCount, defaultDeterminationMovement);
        target.move(5);
        RaceCount raceCount = new RaceCount(defaultPlayCount);
        raceCount.race(true);
        Car source = new Car(name, raceCount, defaultDeterminationMovement);

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        String name = "car";
        Car target = new Car(name, defaultRaceCount, defaultDeterminationMovement);
        target.move(5);
        RaceCount raceCount = new RaceCount(defaultPlayCount);
        Car source = new Car(name, raceCount, defaultDeterminationMovement);

        assertNotEquals(target.getForwardCount(), source.getForwardCount());
        assertNotEquals(target, source);
    }

}