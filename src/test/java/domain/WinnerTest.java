package domain;

import application.CarsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {
    private String name;
    private Cars cars;
    private Winner winner;

    @BeforeEach
    void setUp() {
        name = "pobi, crong, mir";
        cars = CarsGenerator.generate(name);
    }

    @Test
    @DisplayName("전부 우승자일 경우")
    void findWinner1() {
        move(5);
        winner = new Winner(cars, 5);

        assertEquals(3, winner.findWinner().getSize());
    }

    @Test
    @DisplayName("우승자가 없을 경우")
    void findWinner2() {
        move(4);
        winner = new Winner(cars, 5);

        assertEquals(0, winner.findWinner().getSize());
    }

    private void move(final int count) {
        for (int i = 0; i < count; i++) {
            cars = cars.move(() -> true);
        }
    }
}
