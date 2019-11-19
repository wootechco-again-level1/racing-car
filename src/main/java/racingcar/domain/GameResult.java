package racingcar.domain;

import racingcar.domain.exception.NotExistMovedCarException;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameResult {
    private final List<MovedCar> movedCars;

    GameResult(List<MovedCar> movedCars) {
        this.movedCars = movedCars;
    }

    public Winner calculateGameWinner() {
        int maxDistance = calculateMaxDistance();
        List<MovedCar> winners = getWinners(maxDistance);

        return new Winner(winners);
    }

    private int calculateMaxDistance() {
        Comparator<Integer> maxDistanceComparator = (prev, current) -> prev > current ? 1 : -1;

        return movedCars.stream()
                .map(MovedCar::getDistance)
                .max(maxDistanceComparator)
                .orElseThrow(NotExistMovedCarException::new);
    }

    private List<MovedCar> getWinners(int maxDistance) {
        return movedCars.stream()
                .filter(movedCar -> movedCar.isWinner(maxDistance))
                .collect(Collectors.toList());
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
