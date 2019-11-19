package racingcar.domain;

import java.util.List;

public class RoundResults {
    private final List<RoundResult> roundResults;

    public RoundResults(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public RoundResult get(int index) {
        return roundResults.get(index);
    }
}
