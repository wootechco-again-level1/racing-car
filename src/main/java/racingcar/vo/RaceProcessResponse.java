package racingcar.vo;

import java.util.Map;
import java.util.Objects;

/**
 * 레이스 중간 결과들 response vo
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class RaceProcessResponse {
    private final Map<String, Integer> raceProcess;

    public RaceProcessResponse(final Map<String, Integer> raceProcess) {
        this.raceProcess = raceProcess;
    }

    public Map<String, Integer> getRaceProcess() {
        return raceProcess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceProcessResponse that = (RaceProcessResponse) o;

        return Objects.equals(raceProcess, that.raceProcess);
    }

    @Override
    public int hashCode() {
        return raceProcess != null ? raceProcess.hashCode() : 0;
    }
}
