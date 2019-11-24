package racingcar.service.converter;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RaceCount;
import racingcar.domain.RacingCars;
import racingcar.vo.RaceProcessResponse;
import racingcar.vo.RaceWinnerResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
class ResponseConverterTest {
    @Test
    void toRaceProcessDto() {
        String name1 = "car1";
        String name2 = "car2";
        String name3 = "car3";
        Cars cars = Cars.of(new Car(name1, () -> true), new Car(name2, () -> false), new Car(name3, () -> true));
        cars.race();

        RaceProcessResponse dto = ResponseConverter.toRaceProcess(cars);
        Map<String, Integer> result = new HashMap<>();
        result.put(name1, 1);
        result.put(name2, 0);
        result.put(name3, 1);
        RaceProcessResponse resultDto = new RaceProcessResponse(result);

        assertEquals(dto, resultDto);
    }

    @Test
    void toRaceWinnerDto() {
        String name1 = "car1";
        String name2 = "car2";
        String name3 = "car3";
        Cars cars = Cars.of(new Car(name1, () -> true), new Car(name2, () -> false), new Car(name3, () -> true));
        int count = 5;
        RacingCars racingCars = new RacingCars(cars, new RaceCount(count));
        IntStream.range(0, count).forEach(index -> racingCars.race());

        RaceWinnerResponse dto = ResponseConverter.toRaceWinner(racingCars.generateFinalWinner());
        List<String> result = Arrays.asList(name1, name3);
        RaceWinnerResponse resultDto = new RaceWinnerResponse(result);
        assertEquals(dto, resultDto);
    }
}