package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.IllegalCarNameException;

import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class CarTest {
    private Car car;
    private IntPredicate defaultDeterminationMovement = number -> number >= 4;

    @BeforeEach
    void setUp() {
        car = new Car("car", defaultDeterminationMovement);
    }

    @Test
    void constructor_name() {
        String carName = "first";
        Car car = new Car(carName, defaultDeterminationMovement);
        assertEquals(car.getName(), carName);
    }

    @ParameterizedTest
    @MethodSource("invalidNames")
    void constructor_name_exception(final String invalidName) {
        assertThrows(IllegalCarNameException.class, () -> {
            new Car(invalidName, defaultDeterminationMovement);
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
        Car target = new Car(name, defaultDeterminationMovement);
        Car source = new Car(name, number -> number >= 4);

        assertEquals(target, source);
    }

    @Test
    void equals_move() {
        String name = "car";
        Car target = new Car(name, defaultDeterminationMovement);
        target.move(5);
        Car source = new Car(name, defaultDeterminationMovement);
        source.move(6);

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        String name = "car";
        Car target = new Car(name, defaultDeterminationMovement);
        target.move(5);
        Car source = new Car(name, defaultDeterminationMovement);

        assertNotEquals(target.getForwardCount(), source.getForwardCount());
        assertNotEquals(target, source);
    }

    @Test
    void race_true() {
        Car car = new Car("car", number -> true);
        assertEquals(car.getForwardCount(), 0);

        car.race();

        assertEquals(car.getForwardCount(), 1);
    }

    @Test
    void race_false() {
        Car car = new Car("car", number -> false);
        assertEquals(car.getForwardCount(), 0);

        car.race();
        assertEquals(car.getForwardCount(), 0);
    }

    @Test
    void sameForwardCount() {
        Car car = new Car("car", number -> true);
        assertFalse(car.isSameCount(1));
        car.race();
        assertTrue(car.isSameCount(1));
    }
}