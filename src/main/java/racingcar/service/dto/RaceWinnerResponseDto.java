package racingcar.service.dto;

import java.util.List;
import java.util.Objects;

/**
 * 레이스 최종 결과 response dto
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class RaceWinnerResponseDto {
    private final List<String> winners;

    public RaceWinnerResponseDto(final List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceWinnerResponseDto that = (RaceWinnerResponseDto) o;

        return Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return winners != null ? winners.hashCode() : 0;
    }
}
