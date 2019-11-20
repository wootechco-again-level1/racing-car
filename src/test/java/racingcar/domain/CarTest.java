package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.IllegalCarNameException;

import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class CarTest {
    private static final int DEFAULT_RACE_COUNT = 5;

    private Car car;
    private PlayRaceCount defaultPlayCount = new PlayRaceCount(DEFAULT_RACE_COUNT);
    private IntPredicate defaultDeterminationMovement = number -> number >= 4;

    @BeforeEach
    void setUp() {
        car = new Car("car", defaultPlayCount, defaultDeterminationMovement);
    }

    @Test
    void constructor_name() {
        String carName = "first";
        Car car = new Car(carName, defaultPlayCount, defaultDeterminationMovement);
        assertEquals(car.getName(), carName);
    }

    @ParameterizedTest
    @MethodSource("invalidNames")
    void constructor_name_exception(final String invalidName) {
        assertThrows(IllegalCarNameException.class, () -> {
            new Car(invalidName, defaultPlayCount, defaultDeterminationMovement);
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
}