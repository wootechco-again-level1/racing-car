package racingcar.controller;

import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.service.RacingCarsService;
import racingcar.service.dto.RaceProcessResponseDto;
import racingcar.service.dto.RaceWinnerResponseDto;

import java.util.function.IntPredicate;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class RacingCarsController {
    private final RacingCarsService service;

    public RacingCarsController(final RacingCarsService service) {
        this.service = service;
    }

    public void createCars(final NamesRequestDto requestDto, final IntPredicate determineMovement) {
        service.createCars(requestDto, determineMovement);
    }

    public void createRacingCars(final RacingCountRequestDto requestDto) {
        service.createRacingCars(requestDto);
    }

    public boolean hasNextRace() {
        return service.hasNextRace();
    }

    public RaceProcessResponseDto race() {
        service.race();
        return service.getRaceProcess();
    }

    public RaceWinnerResponseDto getWinner() {
        return service.getWinner();
    }
}
