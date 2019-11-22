package racingcar.converter;

import racingcar.controller.dto.NamesRequestDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 뷰에서 받은 데이터를 controller에서 사용할 수 있게 변경한다.
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-22
 */
public class RequestConverter {
    /**
     * 이름을 받아서 자동차 객체를 만들 수 있는 dto로 변경하는 함수.
     *
     * @param data
     * @return
     */
    public static NamesRequestDto toNamesDto(final String data) {
        String regex = ",";
        List<String> requestDto = Arrays.stream(data.split(regex)).map(String::trim).collect(Collectors.toList());
        return new NamesRequestDto(requestDto);
    }
}
