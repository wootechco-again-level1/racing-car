package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarsController;
import racingcar.controller.converter.RequestConverter;
import racingcar.service.RacingCarsService;
import racingcar.vo.RaceProcessResponse;
import racingcar.vo.RaceWinnerResponse;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
class AcceptanceTest {
    private String inputNames;
    private List<String> names;
    private IntPredicate determineMovement;
    private int inputRaceCount;

    @BeforeEach
    void setUp() {
        inputNames = "heebg, cony, ike, 미르, cheol";
        names = Arrays.stream(inputNames.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
        determineMovement = number -> true;
        inputRaceCount = 5;
    }

    @Test
    void main() {
        RacingCarsController controller = new RacingCarsController(new RacingCarsService());
        controller.createCars(RequestConverter.toNamesDto(inputNames), determineMovement);
        controller.createRacingCars(RequestConverter.toRacingCount(inputRaceCount));

        int raceCount = 1;
        while (controller.hasNextRace()) {
            RaceProcessResponse raceProcessResponse = controller.race();
            Map<String, Integer> raceProcess = getRaceProcessOutput(raceCount);
            assertEquals(raceProcessResponse.getRaceProcess(), raceProcess);
            raceCount++;
        }
        RaceWinnerResponse winnerResponseDto = controller.getWinner();
        List<String> winnersOutput = names;
        assertEquals(winnerResponseDto.getWinners(), winnersOutput);
    }

    private Map<String, Integer> getRaceProcessOutput(int raceCount) {
        Map<String, Integer> raceProcess = new LinkedHashMap<>();
        for (String name : names) {
            raceProcess.put(name, raceCount);
        }
        return raceProcess;
    }
}