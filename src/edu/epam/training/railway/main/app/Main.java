package edu.epam.training.railway.main.app;


import edu.epam.training.railway.main.bean.train.Train;
import edu.epam.training.railway.main.service.CarSorter;
import edu.epam.training.railway.main.service.FileDataReader;
import edu.epam.training.railway.main.repository.TrainRepository;
import edu.epam.training.railway.main.service.DataValidator;
import edu.epam.training.railway.main.service.ItemHolder;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args){

        Optional<ArrayList<String>> optStringArrayList;
        Optional<ArrayList<String>> optValidStrings;
        ArrayList<String> validStrings;
        ItemHolder itemHolder = new ItemHolder();

        FileDataReader fileDataReader = new FileDataReader();
        optStringArrayList = fileDataReader.readToStringArrayList("correct.txt");

        DataValidator dataValidator = new DataValidator();
        optValidStrings = dataValidator.validateData(optStringArrayList);
        if(!optValidStrings.isPresent()) return;
        validStrings = optValidStrings.get();

        logger.info(optValidStrings.isPresent());
        logger.info("all strings:\n" + optStringArrayList.toString());
        logger.info("validStrings:\n" + validStrings.toString());

        TrainRepository trainRepository = new TrainRepository();
        trainRepository.add(itemHolder,validStrings);


        for(Train train : trainRepository.get(itemHolder)){
            logger.info("Before sorting: " + train.toString());
            train.setCars(Optional.of(new CarSorter().sortByIDThenByPassengersCount(train.getCars())));
            logger.info("After sorting: " + train.toString());

            logger.info("Cars with PassengerCount between 36 and 54:\n" + trainRepository.findByPassengerCount(train.getCars(), 36, 54));
            logger.info("Cars with ID between 40003 and 40006:\n" + trainRepository.findCarsBetweenIDs(train.getCars(), 40003, 40006));

            //remove Car with ID 40004
            trainRepository.removeCar(itemHolder, train.getTrainID().get(), 40004);
            logger.info("After removing Car with ID 40004" + train.toString());

        }

    }
}
