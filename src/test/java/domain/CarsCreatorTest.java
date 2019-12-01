package domain;

import exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsCreatorTest {
    @Test
    @DisplayName("Cars 객체가 잘 만들어지는지 확인한다.")
    void createCarsTest_Success() {
        Cars cars = CarsCreator.createCars("cony,ike,pobi");

        assertThat(cars).isExactlyInstanceOf(Cars.class);
    }

    @Test
    @DisplayName("중복된 이름에 예외를 던지는지 확인한다.")
    void createCarsTest_Fail() {
        assertThrows(InvalidNameException.class,
                () -> CarsCreator.createCars("cony,cony,ike")
        );
    }
}