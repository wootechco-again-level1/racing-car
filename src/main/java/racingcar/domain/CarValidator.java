package racingcar.domain;

import racingcar.domain.exception.InvalidCarNameLengthException;

class CarValidator {

    static void validCarLength(String name) {
        if (name.length() > 5) {
            throw new InvalidCarNameLengthException();
        }
    }
}
