package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {
    private String name;
    private Cars cars;

    @BeforeEach
    void setUp() {
        name = "pobi, crong, mir";
        String[] names = name.replace(" ", "").split(",");
        cars = new Cars(Arrays.stream(names)
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList())
        );
    }

    @Test
    @DisplayName("자동차들 생성")
    void createCars() {
        assertEquals(cars.getSize(), 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:pobi", "1:crong", "2:mir"}, delimiter = ':')
    @DisplayName("모든 자동차들 이동")
    void movedCars(final int index, final String name) {
        cars = cars.move(() -> true);
        assertEquals(cars.get(index), new Car(name, 1));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:pobi", "1:crong", "2:mir"}, delimiter = ':')
    @DisplayName("모든 자동차들 이동하지 않음")
    void doNotMovedCar(final int index, final String name) {
        cars = cars.move(() -> false);
        assertEquals(cars.get(index), new Car(name, 0));
    }
}
