package edu.epam.training.railway.main.service;

import edu.epam.training.railway.main.bean.car.CargoCar;
import edu.epam.training.railway.main.bean.car.PassengerCar;
import edu.epam.training.railway.main.bean.train.TrainType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public class DataValidator {

    private static final Logger logger = Logger.getLogger(DataValidator.class);

    private ArrayList<String> validStrings = new ArrayList<>();

    public Optional<ArrayList<String>> validateData(Optional<ArrayList<String>> optInputStrings){

        if(!optInputStrings.isPresent()) {
            logger.info("File is empty");
            return Optional.empty();
        }

        ArrayList<String> inputStrings = optInputStrings.get();
        Optional<String> optTrainType = validateTrainType(inputStrings.get(0));
        String trainType;
        Long trainID;
        Optional<String> optInputString;
        Optional<Long> optTrainID;

        if(optTrainType.isPresent()){
            trainType = optTrainType.get();
        }
        else { return Optional.empty(); }

        optTrainID = validateTrainID(inputStrings.get(0));
        if(optTrainID.isPresent()){
            trainID = optTrainID.get();
        }
        else { return Optional.empty(); }

        String validString = trainType+","+trainID;
        validStrings.add(validString);

        for(int i = 1; i < inputStrings.size(); i++){

            optInputString = validateCars(inputStrings.get(i));

            if(optInputString.isPresent()){
                validStrings.add(optInputString.get());
            }
        }

        return Optional.of(validStrings);

    }

    public Optional<String> validateTrainType(String inputString) {

        String trainType = inputString.split(",")[0].toUpperCase();

        try {
            for (int i = 0; i < TrainType.values().length; i++) {
                if (TrainType.valueOf(trainType).equals(TrainType.values()[i])) {
                    break;
                }
                if (i == TrainType.values().length - 1) {
                    logger.info("No such Train Type: " + trainType);
                    return Optional.empty();
                }
            }
        }
        catch (NumberFormatException nfe){
            logger.error("NumberFormatException Wrong: " + nfe.getCause());
            return Optional.empty();
        }
        catch (ArrayIndexOutOfBoundsException nfe){
            logger.error("ArrayIndexOutOfBoundsException Wrong: " + nfe.getCause());
            return Optional.empty();
        }
        catch (IllegalArgumentException iae){
            logger.info(iae.getMessage());
            return Optional.empty();
        }

        return Optional.of(trainType);
    }

    public Optional<Long> validateTrainID(String inputString){

        Long trainID;
        try{
            trainID = Long.valueOf(inputString.split(",")[1]);
        }
        catch (NumberFormatException nfe){
            logger.error("NumberFormatException Wrong: " + nfe.getCause());
            return Optional.empty();
        }
        catch (ArrayIndexOutOfBoundsException nfe){
            logger.error("ArrayIndexOutOfBoundsException Wrong: " + nfe.getCause());
            return Optional.empty();
        }
        catch (IllegalArgumentException iae){
            logger.info(iae.getMessage());
            return Optional.empty();
        }
        if(trainID < 0) {
            logger.info("trainID " + trainID + " < 0 ");
            return Optional.empty();
        }
        return Optional.of(trainID);

    }

    public Optional<String> validateCars(String inputString){

        String[] fields = inputString.split(",");

        try{

            long id = Long.valueOf(fields[0]);
            if(id<=0) return Optional.empty();

            String carType = fields[1].toUpperCase();
            int passengers = Integer.parseInt(fields[2]);
            int weight = Integer.parseInt(fields[3]);
            switch(carType){

                case "PASSENGER":
                    PassengerCar.PassengerCarClass passengerCarClass = PassengerCar.PassengerCarClass.valueOf(fields[4].toUpperCase());
                    break;
                case "CARGO":
                    CargoCar.CargoType cargoType = CargoCar.CargoType.valueOf(fields[4].toUpperCase());
                    break;
                case "LOCOMOTIVE":
                    Double maxPower = Double.parseDouble(fields[4]);
                    break;
                default:
                    logger.info("No such Car Type " + carType);
                    break;
            }

        }catch (NumberFormatException nfe){
            logger.error("NumberFormatException Wrong: " + nfe.getCause());
            return Optional.empty();
        }catch (Exception e){
            logger.error(e.getMessage() + e.getCause());
            return Optional.empty();
        }

        return Optional.of(inputString);
    }
}
