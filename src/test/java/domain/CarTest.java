package domain;

import exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {
    @Test
    @DisplayName("Car 객체가 잘 만들어지는지 확인한다.")
    void constructorTest_Success() {
        Car car = new Car("cony");

        assertThat(car).isExactlyInstanceOf(Car.class);
    }

    @Test
    @DisplayName("5자 이상의 이름에 예외를 던지는지 확인한다.")
    void constructorTest_Fail() {
        assertThrows(InvalidNameException.class,
                () -> new Car("conycony")
        );
    }

    @Test
    @DisplayName("조건에 맞추어 경주하는지 확인한다.")
    void raceTest() {
        Car car = new Car("cony");

        car.race(() -> 3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.race(() -> 4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}