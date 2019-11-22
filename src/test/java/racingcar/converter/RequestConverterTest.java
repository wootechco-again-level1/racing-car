package racingcar.converter;

import org.junit.jupiter.api.Test;
import racingcar.controller.dto.NamesRequestDto;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
class RequestConverterTest {
    @Test
    void toNamesDto() {
        String viewData = "hee, bong, hi";
        NamesRequestDto namesRequestDto = RequestConverter.toNamesDto(viewData);
        NamesRequestDto results = new NamesRequestDto(Arrays.asList("hee", "bong", "hi"));
        assertEquals(namesRequestDto, results);
    }
}