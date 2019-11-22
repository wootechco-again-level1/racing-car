package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private static final String CAR_NAME = "mir";
    private static final int INIT_POSITION = 0;

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
}
