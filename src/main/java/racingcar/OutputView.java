package racingcar;

import racingcar.domain.GameResult;
import racingcar.domain.RoundResults;

public interface OutputView {
    void roundResults(RoundResults roundResults);

    void gameResult(GameResult gameResult);
}
