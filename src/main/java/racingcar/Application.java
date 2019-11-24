package racingcar;

import racingcar.result.RoundResult;
import racingcar.result.Winners;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        int round = InputView.inputRound();

        List<String> carNames = Arrays.asList("car1", "car2", "car3", "car4", "car5");
        RacingGame racingGame = new RacingGame(carNames, round);

        OutputView.printResultIntro();
        while (!racingGame.isFinished()) {
            racingGame.race();
            RoundResult roundResult = racingGame.getRoundResult();
            OutputView.printRoundResult(roundResult.getPositions());
        }

        Winners winners = racingGame.getWinners();
        OutputView.printWinners(winners.getWinnerNames());
    }
}
