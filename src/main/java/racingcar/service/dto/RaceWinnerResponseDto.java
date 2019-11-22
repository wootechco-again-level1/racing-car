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
    private final List<String> data;

    public RaceWinnerResponseDto(final List<String> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceWinnerResponseDto that = (RaceWinnerResponseDto) o;

        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
