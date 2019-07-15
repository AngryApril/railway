package edu.epam.training.railway.main.repository;

import edu.epam.training.railway.main.bean.car.Car;
import edu.epam.training.railway.main.bean.train.Train;
import edu.epam.training.railway.main.service.ItemHolder;
import edu.epam.training.railway.main.service.factory.TrainCreator;
import edu.epam.training.railway.main.specification.CarIDBetweenSpecification;
import edu.epam.training.railway.main.specification.CarPassengerCountBetweenSpecification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alexey.valiev on 5/7/19.
 */
public class TrainRepository implements RwRepository<Train> {

    private static final Logger logger = Logger.getLogger(TrainRepository.class);

    @Override
    public void add(ItemHolder itemHolder, Train item) {

        Train train = new TrainCreator().createTrain(item.getTrainType(),item.getCars());
        countTotals(train);
        itemHolder.addTrain(train);

    }

    public void add(ItemHolder itemHolder, ArrayList<String> stringList) {

        Train train = new TrainCreator().createTrain(itemHolder, stringList);
        countTotals(train);
        itemHolder.addTrain(train);

    }

    @Override
    public void update(ItemHolder itemHolder, Train train) {

        itemHolder.updateTrain(train);
    }

    @Override
    public void remove(ItemHolder itemHolder, Train train) {

        itemHolder.removeTrain(train);
    }

    @Override
    public void remove(ItemHolder itemHolder, long id) {
        for(Train train : itemHolder.getTrainArrayList()){
            if(train.getTrainID().get().equals(id)){
                itemHolder.removeTrain(train);
                break;
            }
        }
    }

    public Optional<Train> get(ItemHolder itemHolder, String id) {

        for (Train train : itemHolder.getTrainArrayList()){
            if(Long.valueOf(id).equals(train.getTrainID().get())){
                return Optional.of(train);
            }
        }

        return Optional.empty();
    }

    @Override
    public ArrayList<Train> get(ItemHolder itemHolder) {
        return itemHolder.getTrainArrayList();
    }

    public ArrayList<Car> findCarsBetweenIDs(ArrayList<Car> fullList, long min, long max){

        ArrayList<Car> selected = new ArrayList<>();
        for(Car car: fullList){
            if(new CarIDBetweenSpecification(min, max).isSatisfiedBy(car)){
                selected.add(car);
            }
        }

        return selected;
    }

    public ArrayList<Car> findByPassengerCount(ArrayList<Car> fullList, int min, int max){

        ArrayList<Car> selected = new ArrayList<>();
        for(Car car: fullList){
            if(new CarPassengerCountBetweenSpecification(min, max).isSatisfiedBy(car)){
                selected.add(car);
            }
        }

        return selected;
    }

    public Optional<Train> findTrainByID(ItemHolder itemHolder, long id){

        for(Train train : itemHolder.getTrainArrayList()){
            if(train.getTrainID().get().equals(id)){
                return Optional.of(train);
            }
        }
        return Optional.empty();
    }



    public void removeCar(ItemHolder itemHolder, long trainID, Car item){

        if(findTrainByID(itemHolder,trainID).isPresent()){
            Train train = findTrainByID(itemHolder, trainID).get();
            CarRepository carRepository = new CarRepository();
            carRepository.setCarArrayList(itemHolder, train.getCars());
            carRepository.remove(itemHolder, item);
            train.setCars(Optional.of(itemHolder.getCarArrayList()));

        }
        else{
            logger.info("No train found with ID: " + trainID);
        }

    }

    public void removeCar(ItemHolder itemHolder, long trainID, long carID){

        if(findTrainByID(itemHolder, trainID).isPresent()){
            Train train = findTrainByID(itemHolder, trainID).get();
            CarRepository carRepository = new CarRepository();
            carRepository.setCarArrayList(itemHolder, train.getCars());
            carRepository.remove(itemHolder, carID);

            train.setCars(Optional.of(itemHolder.getCarArrayList()));
        }
        else{
            logger.info("No train found with ID: " + trainID);
        }

    }

    public void countTotals(Train item){

        int totalPassengerCount = 0;
        double totalWeight = 0;

        for (Car car : item.getCars()){
            totalPassengerCount += car.getPassengers();
            totalWeight += car.getWeight();
        }

        item.setTotalPassengerCount(totalPassengerCount);
        item.setTotalWeight(totalWeight);
    }

}
