package edu.epam.training.railway.main.service.factory;

import edu.epam.training.railway.main.bean.train.Train;
import edu.epam.training.railway.main.bean.car.Car;
import edu.epam.training.railway.main.bean.car.CarType;
import edu.epam.training.railway.main.bean.train.TrainType;
import edu.epam.training.railway.main.repository.CarRepository;
import edu.epam.training.railway.main.service.ItemHolder;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public class TrainCreator {

    private static final Logger logger = Logger.getLogger(TrainCreator.class);

    private ArrayList<Car> cars = new ArrayList<>();
    private int trainID = 0;

    public TrainCreator(){

    }

    public Train createTrain(Optional<TrainType> trainType, ArrayList<Car> carList) {

        int k = 0;
        for (int i = 0; i < carList.size(); i++){
            if(carList.get(i).getCarType().equals(CarType.LOCOMOTIVE)){
                cars.add(carList.get(i));
                k = i;
                break;
            }
        }

        for (int i = 0; i < carList.size(); i++) {
            if (i != k) {
                this.cars.add(carList.get(i));
            } else i++;
        }

        return new Train(trainType.get(),trainID++,cars);


    }

    public Train createTrain(ItemHolder itemHolder, ArrayList<String> strings){

        Train train = new Train();
        logger.info(strings.get(0).split(",")[0].toUpperCase());
        logger.info(strings.get(0).split(",")[1].toUpperCase());

        TrainType trainType = TrainType.valueOf(strings.get(0).split(",")[0].toUpperCase());
        train.setTrainType(Optional.of(trainType));
        train.setTrainID(Optional.of(Long.valueOf(strings.get(0).split(",")[1])));

        CarRepository carRepository = new CarRepository();
        ArrayList<String> carList = new ArrayList<>();

        for(int i = 1; i < strings.size(); i++){
            carList.add(strings.get(i));
        }

        logger.info(carList.toString());
        carRepository.add(itemHolder, carList);
        train.setCars(Optional.ofNullable(itemHolder.getCarArrayList()));

        return train;
    }
}
