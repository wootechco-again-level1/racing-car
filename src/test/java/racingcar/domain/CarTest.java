package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.IllegalCarNameException;
import strategy.MoveStrategy;

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
    private MoveStrategy moveStrategy = () -> true;

    @BeforeEach
    void setUp() {
        car = new Car("car", moveStrategy);
    }

    @Test
    void constructor_name() {
        String carName = "first";
        Car car = new Car(carName, moveStrategy);
        assertEquals(car.getName(), carName);
    }

    @ParameterizedTest
    @MethodSource("invalidNames")
    void constructor_name_exception(final String invalidName) {
        assertThrows(IllegalCarNameException.class, () -> {
            new Car(invalidName, moveStrategy);
        });
    }

    static private Stream<String> invalidNames() {
        return Stream.of("firstC", "", " ", null);
    }

    @Test
    void play_forward() {
        car.race();
        assertEquals(car.getForwardCount(), 1);
    }

    @Test
    void play_stop() {
        Car car = new Car("car", () -> false);
        car.race();
        assertEquals(car.getForwardCount(), 0);
    }

    @Test
    void equals() {
        String name = "car";
        Car target = new Car(name, moveStrategy);
        Car source = new Car(name, () -> true);

        assertEquals(target, source);
    }

    @Test
    void equals_move() {
        String name = "car";
        Car target = new Car(name, moveStrategy);
        target.race();
        Car source = new Car(name, moveStrategy);
        source.race();

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        String name = "car";
        Car target = new Car(name, moveStrategy);
        target.race();
        Car source = new Car(name, moveStrategy);

        assertNotEquals(target.getForwardCount(), source.getForwardCount());
        assertNotEquals(target, source);
    }

    @Test
    void race_true() {
        Car car = new Car("car", moveStrategy);
        assertEquals(car.getForwardCount(), 0);

        car.race();

        assertEquals(car.getForwardCount(), 1);
    }

    @Test
    void race_false() {
        Car car = new Car("car", () -> false);
        assertEquals(car.getForwardCount(), 0);

        car.race();
        assertEquals(car.getForwardCount(), 0);
    }

    @Test
    void sameForwardCount() {
        Car car = new Car("car", () -> true);
        assertFalse(car.isSameCount(1));
        car.race();
        assertTrue(car.isSameCount(1));
    }
}