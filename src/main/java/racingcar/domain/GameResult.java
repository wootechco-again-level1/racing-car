package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class GameResult {
    private final List<MovedCar> movedCars;

    public GameResult(List<MovedCar> movedCars) {
        this.movedCars = movedCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(movedCars, that.movedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movedCars);
    }
}
