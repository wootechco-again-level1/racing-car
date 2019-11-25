package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    @Test
    @DisplayName("게임을 잘 진행하는지 확인한다.")
    void playTest() {
        Cars cars = new Cars(Arrays.asList(new Car("cony"), new Car("ike"), new Car("pobi")));
        int numberOfRound = 5;
        NumberGenerator sevenGenerator = () -> 7;
        List<OneRound> rounds = RacingCarGame.play(cars, numberOfRound, sevenGenerator).getRounds();
        Map<String, Integer> finalRoundStatus = rounds.get(4).getCarStatuses(); // numberOfRound = 5, finalRoundIndex = 4

        for (String name : finalRoundStatus.keySet()) {
            assertThat(finalRoundStatus.get(name)).isEqualTo(5);
        }
    }
}