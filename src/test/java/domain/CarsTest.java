package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = Arrays.asList(new Car("cony"), new Car("ike"), new Car("pobi"));
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("게임 한 라운드를 잘 진행하는지 확인한다.")
    void playOneRoundTest() {
        OneRound oneRound = cars.playOneRound(() -> 5);
        Map<String, Integer> carStatuses = oneRound.getCarStatuses();

        for (String name : carStatuses.keySet()) {
            assertThat(carStatuses.get(name)).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("최대 위치를 잘 리턴하는지 확인한다.")
    void getMaxPositionTest() {
        cars.playOneRound(() -> 7);
        cars.playOneRound(() -> 8);

        assertThat(cars.getMaxPosition()).isEqualTo(2);
    }
}