package edu.epam.training.railway.main.specification;

import org.apache.log4j.Logger;

/**
 * Created by alexey.valiev on 5/7/19.
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

    private static final Logger logger = Logger.getLogger(AbstractSpecification.class);

    public abstract boolean isSatisfiedBy(T t);

}
