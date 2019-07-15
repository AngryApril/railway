package edu.epam.training.railway.main.service.comparator;

import edu.epam.training.railway.main.bean.car.Car;

import java.util.Comparator;

/**
 * Created by alexey.valiev on 5/16/19.
 */
public class IdComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {

        if(o1.getCarID() == o2.getCarID()) return 0;
        else if(o1.getCarID().get() < o2.getCarID().get()) return -1;
        else return 1;
    }
}
