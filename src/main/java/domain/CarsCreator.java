package domain;

import exception.InvalidNameException;

import java.util.*;

public class CarsCreator {
    private static final String DELIMITER = ",";

    public static Cars createCars(String namesInput) {
        String[] names = namesInput.split(DELIMITER);
        checkDuplication(names);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    private static void checkDuplication(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        if (uniqueNames.size() != names.length) {
            throw new InvalidNameException("중복된 이름이 존재합니다.");
        }
    }
}
