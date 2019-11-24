package racingcar.result;

import racingcar.domain.Cars;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoundResult {

    private Map<String, Integer> positions;

    public RoundResult() {
        this.positions = new HashMap<>();
    }

    public void update(Cars cars) {
        positions = cars.getPositions();
    }

    public Map<String, Integer> getPositions() {
        return Collections.unmodifiableMap(positions);
    }
}
