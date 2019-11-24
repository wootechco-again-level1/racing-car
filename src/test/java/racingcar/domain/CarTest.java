package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarValidateException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("이름이 빈칸일 때")
    void invalidName() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(CarValidateException.class);
    }

    @Test
    @DisplayName("이름이 null일 때")
    void invalidName2() {
        assertThatThrownBy(() -> new Car(null)).isInstanceOf(CarValidateException.class);
    }

    @Test
    @DisplayName("이름이 5자 초과일 때")
    void invalidName3() {
        assertThatThrownBy(() -> new Car("aaaaaa")).isInstanceOf(CarValidateException.class);
    }
}