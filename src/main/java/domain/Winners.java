package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Car> winners;

    public Winners(Cars cars) {
        this.winners = findWinners(cars);
    }

    private List<Car> findWinners(Cars cars) {
        int maxPosition = cars.getMaxPosition();
        return cars.getCars().stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    public List<String> getWinnersName() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
