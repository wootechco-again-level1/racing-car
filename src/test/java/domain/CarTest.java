package domain;

import domain.exception.InvalidCarNameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private static final String CAR_NAME = "mir";
    private static final int INIT_POSITION = 0;
    public static final int MAX_DISTANCE = 5;

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME, INIT_POSITION);
    }

    @Test
    @DisplayName("자동차 생성")
    void createCar() {
        assertEquals(car, new Car(CAR_NAME, INIT_POSITION));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "mir"})
    @DisplayName("자동차 이름 길이 5자 이하")
    void checkCarNameLength1(final String name) {
        assertDoesNotThrow(() -> new Car(name, INIT_POSITION));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi123", "crong111", "5글자초과는안돼"})
    @DisplayName("자동차 이름 길이 5자 초과")
    void checkCarNameLength2(final String name) {
        assertThrows(InvalidCarNameLengthException.class, () -> new Car(name, INIT_POSITION));
    }

    @Test
    @DisplayName("자동차 이동")
    void movedCar() {
        assertEquals(car.move(() -> true), new Car(CAR_NAME, 1));
    }

    @Test
    @DisplayName("자동차 이동하지 않음")
    void doNotMovedCar() {
        assertEquals(car.move(() -> false), new Car(CAR_NAME, 0));
    }

    @Test
    @DisplayName("자동차가 결승점에 도달했을 경우")
    void isMaxDistance1() {
        move(MAX_DISTANCE);

        assertTrue(car.isMaxDistance(MAX_DISTANCE));
    }

    @Test
    @DisplayName("자동차가 결승점에 도달하지 못할 경우")
    void isMaxDistance2() {
        move(MAX_DISTANCE - 1);

        assertFalse(car.isMaxDistance(MAX_DISTANCE));
    }

    private void move(final int count) {
        for (int i = 0; i < count; i++) {
            car = car.move(() -> true);
        }
    }
}
