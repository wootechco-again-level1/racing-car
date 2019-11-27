package domain;

import application.CarsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinnerTest {
    private Cars cars;
    private Winner winner;

    @BeforeEach
    void setUp() {
        cars = CarsGenerator.generate("pobi, crong, mir");
    }

    @Test
    @DisplayName("전부 우승자일 경우")
    void findWinner1() {
        move(5);
        winner = new Winner(cars, 5);

        assertFalse(winner.hasNotWinner());
        assertEquals(3, winner.getSize());
    }

    @Test
    @DisplayName("우승자가 없을 경우")
    void findWinner2() {
        move(4);
        winner = new Winner(cars, 5);

        assertTrue(winner.hasNotWinner());
        assertEquals(0, winner.getSize());
    }

    private void move(final int count) {
        for (int i = 0; i < count; i++) {
            cars = cars.move(() -> true);
        }
    }
}
