package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputNames(), InputView.inputRound());

        OutputView.printResultIntro();
        while (racingGame.remainRound()) {
            racingGame.race();
            OutputView.printRoundResult(racingGame.getPositions());
        }

        OutputView.printWinners(racingGame.getWinners());
    }
}
