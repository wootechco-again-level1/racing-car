package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.IllegalCarNameException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class CarTest {
    private PlayRaceCount defaultPlayCount = new PlayRaceCount(5);

    @Test
    void constructor_name() {
        String carName = "first";
        Car car = new Car(carName, defaultPlayCount);
        assertEquals(car.getName(), carName);
    }

    @ParameterizedTest
    @MethodSource("invalidNames")
    void constructor_name_exception(final String invalidName) {
        assertThrows(IllegalCarNameException.class, () -> {
            new Car(invalidName, defaultPlayCount);
        });
    }

    static private Stream<String> invalidNames() {
        return Stream.of("firstC", "", " ", null);
    }
}