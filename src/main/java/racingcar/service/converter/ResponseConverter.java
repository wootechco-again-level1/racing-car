package racingcar.service.converter;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.vo.RaceProcessResponse;
import racingcar.vo.RaceWinnerResponse;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 도메인 객체를 뷰에서 사용할 수 있도록 변경한다.
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class ResponseConverter {
    /**
     * 현재 레이스 결과들을 볼 수 있는 dto로 바꾸는 함수.
     *
     * @param cars
     * @return
     */
    public static RaceProcessResponse toRaceProcess(final Cars cars) {
        Map<String, Integer> dto = new LinkedHashMap<>();
        cars.forEach(car -> dto.put(car.getName(), car.getForwardCount()));
        return new RaceProcessResponse(dto);
    }

    /**
     * 최종 레이스 결과를 볼 수 있는 dto로 바꾸는 함수.
     *
     * @param winner
     * @return
     */
    public static RaceWinnerResponse toRaceWinner(final Winners winner) {
        List<String> dto = winner.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        return new RaceWinnerResponse(dto);
    }
}
