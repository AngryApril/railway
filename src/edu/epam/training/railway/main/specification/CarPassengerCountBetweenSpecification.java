package edu.epam.training.railway.main.specification;

import edu.epam.training.railway.main.bean.car.Car;

/**
 * Created by alexey.valiev on 5/19/19.
 */
public class CarPassengerCountBetweenSpecification extends AbstractSpecification<Car> {

    private int minPassengerCount;
    private int maxPassengerCount;

    public CarPassengerCountBetweenSpecification(int minPassengerCount, int maxPassengerCount) {
        this.minPassengerCount = minPassengerCount;
        this.maxPassengerCount = maxPassengerCount;
    }

    @Override
    public boolean isSatisfiedBy(Car car) {

        return car.getPassengers() >= minPassengerCount && car.getPassengers() <= maxPassengerCount;
    }
}
