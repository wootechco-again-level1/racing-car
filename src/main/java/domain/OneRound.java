package domain;

import java.util.Collections;
import java.util.Map;

public class OneRound {
    private Map<String, Integer> carStatuses;

    public OneRound(Map<String, Integer> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public Map<String, Integer> getCarStatuses() {
        return Collections.unmodifiableMap(carStatuses);
    }
}
