package racingcar.controller;

import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.service.RacingCarsService;
import racingcar.vo.RaceProcessResponse;
import racingcar.vo.RaceWinnerResponse;
import strategy.MoveStrategy;

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

    public void createCars(final NamesRequestDto requestDto, final MoveStrategy moveStrategy) {
        service.createCars(requestDto, moveStrategy);
    }

    public void createRacingCars(final RacingCountRequestDto requestDto) {
        service.createRacingCars(requestDto);
    }

    public boolean hasNextRace() {
        return service.hasNextRace();
    }

    public RaceProcessResponse race() {
        service.race();
        return service.getRaceProcess();
    }

    public RaceWinnerResponse getWinner() {
        return service.getWinner();
    }
}
