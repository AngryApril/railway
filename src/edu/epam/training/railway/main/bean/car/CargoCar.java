package edu.epam.training.railway.main.bean.car;

import org.apache.log4j.Logger;

import java.util.Optional;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public class CargoCar extends Car {

    private static final Logger logger = Logger.getLogger(CargoCar.class);
    private Optional<CargoType> cargoType;

    public CargoCar(long carID, CarType carType, int passengers, double weight, CargoType cargoType) {
        super(carID, carType, passengers, weight);
        this.cargoType = Optional.of(cargoType);
    }

    public enum CargoType{
        PLATFORM,
        TANKER
    }

    public Optional<CargoType> getCargoType() {
        return cargoType;
    }

    public void setCargoType(Optional<CargoType> cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public String toString() {
        return super.toString() + " cargoType: " + cargoType.get() + "\n";
    }
}
