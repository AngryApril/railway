package edu.epam.training.railway.main.specification;

import edu.epam.training.railway.main.bean.Identity;

import java.util.function.Predicate;

/**
 * Created by alexey.valiev on 5/7/19.
 */
public interface Specification<T> {

    boolean isSatisfiedBy(T t);

}
