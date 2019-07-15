package edu.epam.training.railway.main.bean.car;

import org.apache.log4j.Logger;

import java.util.Optional;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public class Locomotive extends Car{

    private static final Logger logger = Logger.getLogger(Locomotive.class);

    private Optional<Double> maxPower;

    public Locomotive(long carID, CarType carType, int passengers, double weight, double maxPower) {
        super(carID, carType, passengers, weight);
        this.maxPower = Optional.ofNullable(maxPower);
    }

    public Optional<Double> getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Optional<Double> maxPower) {
        this.maxPower = maxPower;
    }

    @Override
    public String toString() {
        return super.toString() + " maxPower: " + maxPower.get() + "\n";
    }
}
