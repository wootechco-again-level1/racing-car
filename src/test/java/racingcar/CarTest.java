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

    @Test
    @DisplayName("이동조건 일 때, 이동 잘 하는지")
    void move() {
        Car car1 = new Car("ike");
        Car car2 = new Car("ike");
        car1.move(true);

        assertThat(car1.getPosition()).isNotEqualTo(car2.getPosition());
    }
}