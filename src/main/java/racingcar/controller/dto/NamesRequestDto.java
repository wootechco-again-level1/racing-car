package racingcar.controller.dto;

import java.util.List;
import java.util.Objects;

/**
 * 자동차 이름 request vo
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class NamesRequestDto {
    private final List<String> names;

    public NamesRequestDto(final List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NamesRequestDto that = (NamesRequestDto) o;

        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return names != null ? names.hashCode() : 0;
    }
}
