package racingcar.controller.dto;

/**
 * 레이스 횟수 request vo
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class RacingCountRequestDto {
    private final int count;

    public RacingCountRequestDto(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
