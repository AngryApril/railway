package edu.epam.training.railway.main.specification;

import edu.epam.training.railway.main.bean.car.Car;

/**
 * Created by alexey.valiev on 5/20/19.
 */
public class CarIDBetweenSpecification extends AbstractSpecification<Car> {

    private long minID;
    private long maxID;

    public CarIDBetweenSpecification(long minID, long maxID) {

        this.minID = minID;
        this.maxID = maxID;
    }

    @Override
    public boolean isSatisfiedBy(Car car) {

        return car.getCarID().get() >= minID && car.getCarID().get() <= maxID;
    }
}
