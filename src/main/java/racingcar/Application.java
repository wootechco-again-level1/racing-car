package racingcar;

import racingcar.result.RoundResult;
import racingcar.result.Winners;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputNames(), InputView.inputRound());

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
