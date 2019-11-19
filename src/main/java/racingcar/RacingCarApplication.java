package racingcar;

import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.domain.RoundResults;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class RacingCarApplication {

    public static void run() {
        InputInteractor inputInteractor = new InputInteractor(new ConsoleInputView());
        OutputView outputView = new ConsoleOutputView();

        RacingGame racingGame = inputInteractor.readyForGame();

        RoundResults roundResults = racingGame.startGame();
        outputView.roundResults(roundResults);

        GameResult gameResult = racingGame.generateGameResult();
        outputView.gameResult(gameResult);
    }
}
