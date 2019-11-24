package racingcar.service;

import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.domain.Cars;
import racingcar.domain.RaceCount;
import racingcar.domain.RacingCars;
import racingcar.service.converter.ResponseConverter;
import racingcar.vo.RaceProcessResponse;
import racingcar.vo.RaceWinnerResponse;
import strategy.MoveStrategy;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class RacingCarsService {
    private Cars cars;
    private RacingCars racingCars;

    public void createCars(final NamesRequestDto requestDto, final MoveStrategy moveStrategy) {
        cars = new Cars(requestDto.getNames(), moveStrategy);
    }

    public void createRacingCars(final RacingCountRequestDto requestDto) {
        RaceCount raceCount = new RaceCount(requestDto.getCount());
        racingCars = new RacingCars(cars, raceCount);
    }

    public boolean hasNextRace() {
        return racingCars.hasNext();
    }

    public void race() {
        racingCars.race();
    }

    public RaceProcessResponse getRaceProcess() {
        return ResponseConverter.toRaceProcess(racingCars.getCars());
    }

    public RaceWinnerResponse getWinner() {
        return ResponseConverter.toRaceWinner(racingCars.generateFinalWinner());
    }
}
