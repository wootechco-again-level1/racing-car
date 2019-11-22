package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("이동시 위치 변경")
    void increaseTest() {
        Position position = new Position();
        assertThat(position.increase()).isEqualTo(1);
    }
}