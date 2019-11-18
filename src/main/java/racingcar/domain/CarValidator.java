package racingcar.domain;

class CarValidator {

    static void validCarLength(String name) {
        if (name.length() > 5) {
            throw new InvalidCarNameLengthException();
        }
    }
}
