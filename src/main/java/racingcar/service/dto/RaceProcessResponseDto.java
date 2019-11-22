package racingcar.service.dto;

import java.util.Map;
import java.util.Objects;

/**
 * 레이스 중간 결과들 response dto
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class RaceProcessResponseDto {
    private final Map<String, Integer> raceProcess;

    public RaceProcessResponseDto(final Map<String, Integer> raceProcess) {
        this.raceProcess = raceProcess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceProcessResponseDto that = (RaceProcessResponseDto) o;

        return Objects.equals(raceProcess, that.raceProcess);
    }

    @Override
    public int hashCode() {
        return raceProcess != null ? raceProcess.hashCode() : 0;
    }
}
