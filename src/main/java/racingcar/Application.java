package racingcar;

import racingcar.controller.RacingCarsController;
import racingcar.converter.RequestConverter;
import racingcar.service.RacingCarsService;
import racingcar.service.dto.RaceProcessResponseDto;
import racingcar.service.dto.RaceWinnerResponseDto;

import java.util.Scanner;
import java.util.function.IntPredicate;

import static racingcar.view.InputView.inputNames;
import static racingcar.view.InputView.inputRaceCount;
import static racingcar.view.OutputView.outputProcess;
import static racingcar.view.OutputView.outputProcessTitle;
import static racingcar.view.OutputView.outputWinner;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IntPredicate determineMovement = number -> number >= 4;
        RacingCarsController controller = new RacingCarsController(new RacingCarsService());
        String inputNames = inputNames(scanner);
        controller.createCars(RequestConverter.toNamesDto(inputNames), determineMovement);
        int inputCount = inputRaceCount(scanner);
        controller.createRacingCars(RequestConverter.toRacingCount(inputCount));

        outputProcessTitle();
        while (controller.hasNextRace()) {
            RaceProcessResponseDto raceProcessResponseDto = controller.race();
            outputProcess(raceProcessResponseDto.getRaceProcess());
        }
        RaceWinnerResponseDto winnerResponseDto = controller.getWinner();
        outputWinner(winnerResponseDto.getWinners());
    }
}
