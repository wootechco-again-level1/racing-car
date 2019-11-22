package racingcar.service;

import racingcar.controller.dto.NamesRequestDto;
import racingcar.controller.dto.RacingCountRequestDto;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RaceCount;
import racingcar.domain.RacingCars;
import racingcar.service.dto.RaceProcessResponseDto;
import racingcar.service.dto.RaceWinnerResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

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
        Map<String, Integer> dto = new HashMap<>();
        racingCars.getCars().forEach(car -> dto.put(car.getName(), car.getForwardCount()));
        return new RaceProcessResponseDto(dto);
    }

    public RaceWinnerResponseDto getWinner() {
        List<String> dto = racingCars.generateFinalWinner().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        return new RaceWinnerResponseDto(dto);
    }
}
