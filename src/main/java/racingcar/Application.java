package racingcar;

import racingcar.domain.Cars;
import racingcar.service.RacingGame;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = Arrays.asList("car1", "car2", "car3", "car4", "car5");
        Cars cars = new Cars(carNames);
        int round = 5;

        RacingGame racingGame = new RacingGame(cars, round);
        racingGame.race();

        List<String> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}
