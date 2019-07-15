package edu.epam.training.railway.main.repository;

import edu.epam.training.railway.main.bean.car.Car;
import edu.epam.training.railway.main.bean.train.Train;
import edu.epam.training.railway.main.service.ItemHolder;
import edu.epam.training.railway.main.service.factory.CarCreator;
import edu.epam.training.railway.main.specification.Specification;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by alexey.valiev on 5/16/19.
 */
public class CarRepository implements RwRepository<Car>{

    private static final Logger logger = Logger.getLogger(CarRepository.class);

    @Override
    public void add(ItemHolder itemHolder, Car car) {

        itemHolder.addCar(car);
    }

    public void add(ItemHolder itemHolder, ArrayList<String> stringList) {

        Optional<ArrayList<Car>> arrayList = Optional.of(new CarCreator().createCars(stringList)) ;

        logger.info(this.getClass() + ": " + arrayList.isPresent());

        if(arrayList.isPresent()){
            for(Car car : arrayList.get()){
                logger.info(car.toString());
                itemHolder.addCar(car);
            }
        }
    }

    @Override
    public void update(ItemHolder itemHolder, Car car) {

        itemHolder.updateCar(car);
    }

    @Override
    public void remove(ItemHolder itemHolder, Car item) {
        for(Car car : itemHolder.getCarArrayList()){
            if(car.equals(item)){
                itemHolder.removeCar(item);
                break;
            }
        }
    }

    @Override
    public ArrayList<Car> get(ItemHolder itemHolder) {
        return itemHolder.getCarArrayList();
    }

    @Override
    public void remove(ItemHolder itemHolder, long id) {

        if(findCarByID(itemHolder, id).isPresent()){
            itemHolder.removeCar(findCarByID(itemHolder, id).get());
        }
        else{
            logger.info("Car with ID " + id + "Not Found");
        }

    }


    public void setCarArrayList(ItemHolder itemHolder, ArrayList<Car> carArrayList) {
        itemHolder.setCarArrayList(carArrayList);
    }

    public Optional<Car> findCarByID(ItemHolder itemHolder, long carID ){

        for(Car car : itemHolder.getCarArrayList()){
            if(car.getCarID().get().equals(carID)){
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }

    public Optional<Car> findCarByID(ArrayList<Car> cars, long carID ){

        for(Car car : cars){
            if(car.getCarID().get().equals(carID)){
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }

}
