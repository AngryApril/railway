package edu.epam.training.railway.main.service.comparator;

import edu.epam.training.railway.main.bean.car.Car;

import java.util.Comparator;

/**
 * Created by alexey.valiev on 5/16/19.
 */
public class WeightComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        if(o1.getWeight() == o2.getWeight()) return 0;
        else if(o1.getWeight() < o2.getWeight()) return -1;
        else return 1;
    }
}
