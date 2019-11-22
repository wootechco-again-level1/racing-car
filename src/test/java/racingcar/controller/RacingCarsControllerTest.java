package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.service.RacingCarsService;
import racingcar.service.dto.RaceProcessResponseDto;
import racingcar.service.dto.RaceWinnerResponseDto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
class RacingCarsControllerTest {
    private List<String> names;
    private int raceCount;
    private RacingCarsService service;
    private RacingCarsController controller;

    @BeforeEach
    void setUp() {
        names = Arrays.asList("hee", "bong", "hi");
        raceCount = 5;
        service = mock(RacingCarsService.class);
        controller = new RacingCarsController(service);
    }

    @Test
    void createCars() {
        NamesRequestDto namesRequestDto = new NamesRequestDto(names);
        IntPredicate determineMovement = number -> true;
        controller.createCars(namesRequestDto, determineMovement);
        verify(service).createCars(namesRequestDto, determineMovement);
    }

    @Test
    void createRacingCars() {
        RacingCountRequestDto racingCountRequestDto = new RacingCountRequestDto(raceCount);
        controller.createRacingCars(racingCountRequestDto);
        verify(service).createRacingCars(racingCountRequestDto);
    }

    @Test
    void race() {
        Map<String, Integer> result = new HashMap<>();
        names.forEach(name -> result.put(name, 1));
        RaceProcessResponseDto resultDto = new RaceProcessResponseDto(result);
        when(service.getRaceProcess()).thenReturn(resultDto);

        RaceProcessResponseDto dto = controller.race();
        assertEquals(dto, resultDto);

        verify(service).race();
        verify(service).getRaceProcess();
    }

    @Test
    void getWinner() {
        RaceWinnerResponseDto resultDto = new RaceWinnerResponseDto(names);
        when(service.getWinner()).thenReturn(resultDto);

        RaceWinnerResponseDto dto = controller.getWinner();
        assertEquals(dto, resultDto);
        verify(service).getWinner();
    }
}