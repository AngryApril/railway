package edu.epam.training.railway.main.service;

import edu.epam.training.railway.main.bean.car.Car;
import edu.epam.training.railway.main.bean.train.Train;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by alexey.valiev on 5/24/19.
 */
public class ItemHolder {

    private static final Logger logger = Logger.getLogger(ItemHolder.class);

    private ArrayList<Train> trainArrayList = new ArrayList<>();
    private ArrayList<Car> carArrayList = new ArrayList<>();

    public ItemHolder() {
    }

    public void addTrain(Train train){
        trainArrayList.add(train);
    }

    public void updateTrain(Train train){
        int index = trainArrayList.indexOf(train);
        trainArrayList.set(index, train);
    }

    public void removeTrain(Train train){
        trainArrayList.remove(train);
    }

    public void addCar(Car car){
        carArrayList.add(car);
    }

    public void updateCar(Car car){
        int index = carArrayList.indexOf(car);
        carArrayList.set(index, car);
    }

    public void removeCar(Car car){
        carArrayList.remove(car);
    }

    public ArrayList<Train> getTrainArrayList() {
        return trainArrayList;
    }

    public void setTrainArrayList(ArrayList<Train> trainArrayList) {
        this.trainArrayList = trainArrayList;
    }

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public void setCarArrayList(ArrayList<Car> carArrayList) {
        this.carArrayList = carArrayList;
    }

}
