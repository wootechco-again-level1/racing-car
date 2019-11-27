package domain;

import application.CarsGenerator;
import domain.exception.DuplicateNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsGeneratorTest {

    @Test
    @DisplayName("자동차 이름 중복 확인")
    void checkDuplicateNames() {
        String name = "pobi, crong, mir, pobi";
        assertThrows(DuplicateNameException.class, () -> {
            CarsGenerator.generate(name);
        });
    }
}
