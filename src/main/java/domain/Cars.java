package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> list;

    public Cars(final List<Car> cars) {
        this.list = cars;
    }

    public Cars move(final MoveStrategy moveStrategy) {
        return new Cars(list.stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList()))
                ;
    }

    public int getSize() {
        return list.size();
    }

    public Car get(final int index) {
        return list.get(index);
    }
}
