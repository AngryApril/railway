package edu.epam.training.railway.main.service.factory;

import edu.epam.training.railway.main.bean.car.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public class CarCreator {

    private static final Logger logger = Logger.getLogger(CarCreator.class);

    private long carID;

    private ArrayList<Car> cars = new ArrayList<>();
    private final String delimeter = ",";


    public CarCreator() {
    }

    public ArrayList<Car> createCars(ArrayList<String> stringList){

        for(String string : stringList){

            String[] fields = string.split(delimeter);

            try{
                carID = Long.valueOf(fields[0]);

                switch (fields[1].toUpperCase()){

                    case "PASSENGER": cars.add(new PassengerCar(carID,CarType.PASSENGER,Integer.parseInt(fields[2]),
                            Double.parseDouble(fields[3]), PassengerCar.PassengerCarClass.valueOf(fields[4].toUpperCase())));
                        break;
                    case "CARGO": cars.add(new CargoCar(carID,CarType.CARGO,Integer.parseInt(fields[2]),
                            Double.parseDouble(fields[3]), CargoCar.CargoType.valueOf(fields[4].toUpperCase())));
                        break;
                    case "LOCOMOTIVE": cars.add(new Locomotive(carID,CarType.LOCOMOTIVE,Integer.parseInt(fields[2]),
                            Double.parseDouble(fields[3]),Double.parseDouble(fields[4])));
                        break;
                    default: logger.info("NO SUCH CAR TYPE " + fields[1]);
                        break;
                }

            }catch (NumberFormatException nfe){
                logger.error("NFE3 ",nfe.getCause());
            }
        }

        return cars;
    }
}
