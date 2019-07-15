package edu.epam.training.railway.main.bean.car;

import org.apache.log4j.Logger;

import java.util.Optional;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public class PassengerCar extends Car {

    private static final Logger logger = Logger.getLogger(PassengerCar.class);

    private Optional<PassengerCarClass> carClass;

    public PassengerCar(Long carID, CarType carType, int passengers, double weight, PassengerCarClass carClass) {
        super(carID, carType, passengers, weight);
        this.carClass = Optional.ofNullable(carClass);
    }

    public enum PassengerCarClass{
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public Optional<PassengerCarClass> getCarClass() {
        return carClass;
    }

    public void setCarClass(Optional<PassengerCarClass> carClass) {
        this.carClass = carClass;
    }

    @Override
    public String toString() {
        return super.toString() + " carClass: " + carClass.get() + "\n";
    }
}
