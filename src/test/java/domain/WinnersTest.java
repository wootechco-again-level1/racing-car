package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    @DisplayName("우승자 이름을 잘 리턴하는지 확인한다.")
    void getWinnersNameTest() {
        Winners winners = new Winners(Arrays.asList(new Car("cony"), new Car("ike"), new Car("pobi")));
        List<String> winnersName = winners.getWinnersName();

        assertThat(winnersName).isEqualTo(Arrays.asList("cony", "ike", "pobi"));
    }
}