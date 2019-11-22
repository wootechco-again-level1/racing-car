package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("같은 이름일 때, 같은 자동차")
    void sameCarTest() {
        Car car1 = new Car("ike");
        Car car2 = new Car("ike");

        assertThat(car1).isEqualTo(car2);
    }
}