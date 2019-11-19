package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Winner {
    private final List<MovedCar> winners;

    public Winner(List<MovedCar> winners) {
        this.winners = winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(winners, winner.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
