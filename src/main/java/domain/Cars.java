package domain;

import domain.exception.DuplicateNameException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> list;

    public Cars(final List<Car> cars) {
        checkDuplicate(cars);
        this.list = cars;
    }

    private void checkDuplicate(final List<Car> cars) {
        if (cars.size() == new HashSet<>(cars).size()) {
            return;
        }

        throw new DuplicateNameException();
    }

    public Cars move(final MoveStrategy moveStrategy) {
        return new Cars(list.stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList())
        );
    }

    public int getSize() {
        return list.size();
    }

    public Car get(final int index) {
        return list.get(index);
    }

    public List<Car> getCars() {
        return list;
    }

    @Override
    public String toString() {
        return "Cars{" + "list=" + list + '}';
    }
}
