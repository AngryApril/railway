package edu.epam.training.railway.main.bean.train;

import edu.epam.training.railway.main.bean.Identity;
import edu.epam.training.railway.main.bean.car.Car;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public class Train extends Identity {

    private Optional<TrainType> trainType;
    private Optional<Long> trainID;
    private Optional<ArrayList<Car>> cars;
    private int totalPassengerCount = 0;
    private double totalWeight = 0;

    public Train(){}

    public Train(TrainType trainType, long trainID, ArrayList<Car> carList) {
        this.trainType = Optional.ofNullable(trainType);
        this.trainID = Optional.ofNullable(trainID);
        this.cars = Optional.ofNullable(carList);
    }

    public Optional<TrainType> getTrainType() {
        return trainType;
    }

    public void setTrainType(Optional<TrainType> trainType) {
        this.trainType = trainType;
    }

    public Optional<Long> getTrainID() {
        return trainID;
    }

    public void setTrainID(Optional<Long> trainID) {
        this.trainID = trainID;
    }

    public void setCars(Optional<ArrayList<Car>> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {   return cars.get(); }

    public void setTotalPassengerCount(int totalPassengerCount) {
        this.totalPassengerCount = totalPassengerCount;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getTotalPassengerCount() { return totalPassengerCount; }

    public double getTotalWeight() { return totalWeight; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        if (!super.equals(o)) return false;

        Train train = (Train) o;

        if (trainType != null ? !trainType.equals(train.trainType) : train.trainType != null) return false;
        return trainID != null ? trainID.equals(train.trainID) : train.trainID == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (trainType != null ? trainType.hashCode() : 0);
        result = 31 * result + (trainID != null ? trainID.hashCode() : 0);
        return result;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        String train = "\n\n --- **** --- \n\nTrainType: " + trainType.get() + "\nTrainID: " + trainID.get();

        for (Car car : this.getCars()){
            train = train.concat(car.toString());
        }

        train = train.concat("\nTOTAL PassengerCount: " + getTotalPassengerCount());
        train = train.concat("\nTOTAL LuggageCount, kg: " + getTotalWeight());
        train = train.concat("\n\n --- **** --- \n");
        return train;
    }
}
