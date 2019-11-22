package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.service.RacingCarsService;

import java.util.Arrays;
import java.util.function.IntPredicate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
class RacingCarsControllerTest {
    private RacingCarsService service;
    private RacingCarsController controller;

    @BeforeEach
    void setUp() {
        service = mock(RacingCarsService.class);
        controller = new RacingCarsController(service);
    }

    @Test
    void createCars() {
        NamesRequestDto namesRequestDto = new NamesRequestDto(Arrays.asList("hee", "bong", "hi"));
        IntPredicate determineMovement = number -> true;
        controller.createCars(namesRequestDto, determineMovement);
        verify(service).createCars(namesRequestDto, determineMovement);
    }

    @Test
    void createRacingCars() {
        RacingCountRequestDto racingCountRequestDto = new RacingCountRequestDto(5);
        controller.createRacingCars(racingCountRequestDto);
        verify(service).createRacingCars(racingCountRequestDto);
    }
}