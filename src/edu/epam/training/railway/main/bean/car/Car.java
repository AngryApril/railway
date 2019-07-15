package edu.epam.training.railway.main.bean.car;

import edu.epam.training.railway.main.bean.Identity;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public abstract class Car extends Identity{

    private Optional<Long> carID;
    private Optional<CarType> carType;
    private int passengers;
    private double weight;


    public Car(Long carID, CarType carType, int passengers, double weight) {
        this.carID = Optional.ofNullable(carID);
        this.carType = Optional.ofNullable(carType);
        this.passengers = Optional.ofNullable(passengers).orElse(0);
        this.weight = Optional.ofNullable(weight).orElse(0.0);
    }

    public Optional<Long> getCarID() {
        return carID;
    }

    public void setCarID(Optional<Long> carID) {
        this.carID = carID;
    }

    public Optional<CarType> getCarType() {
        return carType;
    }

    public void setCarType(Optional<CarType> carType) {
        this.carType = carType;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "carID: " + carID.get() +
                " carType: " + carType.get() +
                " passengers: " + passengers +
                " weight: " + weight;
    }
}
