package edu.epam.training.railway.main.service;

import edu.epam.training.railway.main.bean.car.Car;
import edu.epam.training.railway.main.service.comparator.IdComparator;
import edu.epam.training.railway.main.service.comparator.PassengerComparator;
import edu.epam.training.railway.main.service.comparator.WeightComparator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by alexey.valiev on 5/18/19.
 */
public class CarSorter {

    static final Logger logger = Logger.getLogger(CarSorter.class);

    public ArrayList<Car> sortByID(ArrayList<Car> sortedList){

        sortedList.sort(new IdComparator());
        return sortedList;
    }

    public ArrayList<Car> sortByPassengersCount(ArrayList<Car> sortedList){

        sortedList.sort(new PassengerComparator());
        return sortedList;
    }

    public ArrayList<Car> sortByWeight(ArrayList<Car> sortedList){

        sortedList.sort(new WeightComparator());
        return sortedList;

    }


    public ArrayList<Car> sortByIDThenByPassengersCount(ArrayList<Car> sortedList){

        Collections.sort(sortedList,new IdComparator()
                .thenComparing(new PassengerComparator()));
        return sortedList;
    }

    public ArrayList<Car> sortByIDthenByWeight(ArrayList<Car> sortedList){

        Collections.sort(sortedList,new IdComparator()
                .thenComparing(new WeightComparator()));
        return sortedList;
    }

    public ArrayList<Car> sortByPassengersCountThenByID(ArrayList<Car> sortedList){

        Collections.sort(sortedList,new PassengerComparator()
                .thenComparing(new IdComparator()));
        return sortedList;
    }

    public ArrayList<Car> sortByPassengersCountThenByWeight(ArrayList<Car> sortedList){

        Collections.sort(sortedList,new PassengerComparator()
                .thenComparing(new WeightComparator()));
        return sortedList;
    }

    public ArrayList<Car> sortByWeightThenByPassengersCount(ArrayList<Car> sortedList){

        Collections.sort(sortedList,new IdComparator()
                .thenComparing(new PassengerComparator()));
        return sortedList;
    }

    public ArrayList<Car> sortByWeightThenByID(ArrayList<Car> sortedList){

        Collections.sort(sortedList,new WeightComparator()
                .thenComparing(new IdComparator()));
        return sortedList;
    }

}
