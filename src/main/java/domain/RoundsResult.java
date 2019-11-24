package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundsResult {
    private final List<OneRound> rounds;

    public RoundsResult() {
        this.rounds = new ArrayList<>();
    }

    public void addOneRound(OneRound oneRound) {
        this.rounds.add(oneRound);
    }

    public List<OneRound> getRounds() {
        return Collections.unmodifiableList(rounds);
    }
}
