package racingcar.service;

import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.domain.Cars;
import racingcar.domain.RaceCount;
import racingcar.domain.RacingCars;
import racingcar.service.converter.ResponseConverter;
import racingcar.service.dto.RaceProcessResponseDto;
import racingcar.service.dto.RaceWinnerResponseDto;

import java.util.function.IntPredicate;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class RacingCarsService {
    private Cars cars;
    private RacingCars racingCars;

    public void createCars(final NamesRequestDto requestDto, final IntPredicate determineMovement) {
        cars = new Cars(requestDto.getNames(), determineMovement);
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

    public RaceProcessResponseDto getRaceProcess() {
        return ResponseConverter.toRaceProcess(racingCars.getCars());
    }

    public RaceWinnerResponseDto getWinner() {
        return ResponseConverter.toRaceWinner(racingCars.generateFinalWinner());
    }
}
