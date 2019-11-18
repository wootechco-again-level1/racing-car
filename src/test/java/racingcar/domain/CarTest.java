package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("Car의 이름이 5자가 넘으면 Exception이 발생한다.")
    void create_IfNameLengthIsOverThan5_ThenException() {
        assertThatThrownBy(() -> new Car("chelsea")).isInstanceOf(InvalidCarNameLengthException.class);
    }

    @Test
    @DisplayName("현재 이동거리가 0인 Car가 이동에 성공했을 시 거리가 1 증가, 실패하면 그대로 있는다.")
    void move() {
        Car car = new Car("pkch");

        assertThat(car.move(3)).isEqualTo(0);
        assertThat(car.move(4)).isEqualTo(1);
    }


}
