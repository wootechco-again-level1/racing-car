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
        Cars cars = new Cars(Arrays.asList(new Car("cony"), new Car("ike"), new Car("pobi")));
        cars.playOneRound(() -> 6);
        Winners winners = new Winners(cars);
        List<String> winnersName = winners.getWinnersName();

        assertThat(winnersName).isEqualTo(Arrays.asList("cony", "ike", "pobi"));
    }
}