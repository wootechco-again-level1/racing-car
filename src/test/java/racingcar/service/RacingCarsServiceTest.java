package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.exception.IllegalCarNameException;
import racingcar.exception.RaceNotCountException;
import racingcar.vo.RaceProcessResponse;
import racingcar.vo.RaceWinnerResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
class RacingCarsServiceTest {
    private List<String> names;
    private int raceCount = 5;
    private RacingCarsService service;

    @BeforeEach
    void setUp() {
        names = Arrays.asList("hee", "bong", "hi");
        service = new RacingCarsService();
        NamesRequestDto namesRequestDto = new NamesRequestDto(names);
        IntPredicate determineMovement = number -> true;
        service.createCars(namesRequestDto, determineMovement);

        RacingCountRequestDto countRequestDto = new RacingCountRequestDto(raceCount);
        service.createRacingCars(countRequestDto);
    }

    @Test
    void createCars() {
        NamesRequestDto requestDto = new NamesRequestDto(names);
        IntPredicate determineMovement = number -> true;
        service.createCars(requestDto, determineMovement);
    }

    @Test
    void createCars_exception() {
        NamesRequestDto requestDto = new NamesRequestDto(Arrays.asList("hee", "", "hi"));
        IntPredicate determineMovement = number -> true;
        assertThrows(IllegalCarNameException.class, () -> {
            service.createCars(requestDto, determineMovement);
        });
    }

    @Test
    void createRacingCars() {
        RacingCountRequestDto requestDto = new RacingCountRequestDto(5);
        service.createRacingCars(requestDto);
    }

    @Test
    void createRacingCars_exception() {
        RacingCountRequestDto requestDto = new RacingCountRequestDto(0);
        assertThrows(RaceNotCountException.class, () -> {
            service.createRacingCars(requestDto);
        });
    }

    @Test
    void hasNextRace() {
        assertTrue(service.hasNextRace());
    }

    @Test
    void getRaceProcess() {
        service.race();
        RaceProcessResponse responseDto = service.getRaceProcess();
        Map<String, Integer> result = new HashMap<>();
        names.forEach(name -> result.put(name, 1));
        RaceProcessResponse resultDto = new RaceProcessResponse(result);
        assertEquals(responseDto, resultDto);
    }

    @Test
    void getWinner() {
        IntStream.range(0, raceCount).forEach(index -> service.race());
        RaceWinnerResponse winnerResponseDto = service.getWinner();
        RaceWinnerResponse resultDto = new RaceWinnerResponse(names);
        assertEquals(winnerResponseDto, resultDto);
    }
}