package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.exception.IllegalCarNameException;
import racingcar.exception.RaceNotCountException;

import java.util.Arrays;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
class RacingCarsServiceTest {
    private RacingCarsService service;

    @BeforeEach
    void setUp() {
        service = new RacingCarsService();
    }

    @Test
    void createCars() {
        NamesRequestDto requestDto = new NamesRequestDto(Arrays.asList("hee", "bong", "hi"));
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
        NamesRequestDto namesRequestDto = new NamesRequestDto(Arrays.asList("hee", "bong", "hi"));
        IntPredicate determineMovement = number -> true;
        service.createCars(namesRequestDto, determineMovement);

        RacingCountRequestDto countRequestDto = new RacingCountRequestDto(5);
        service.createRacingCars(countRequestDto);
        assertTrue(service.hasNextRace());
    }
}