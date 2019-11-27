package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.RoundResult;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputNames(), InputView.inputRound());

        OutputView.printResultIntro();
        while (racingGame.remainRound()) {
            racingGame.race();
            RoundResult roundResult = racingGame.getRoundResult();
            OutputView.printRoundResult(roundResult.getPositions());
        }

        Winners winners = racingGame.getWinners();
        OutputView.printWinners(winners.getWinnerNames());
    }
}
