package edu.epam.training.railway.main.repository;
import edu.epam.training.railway.main.bean.Identity;
import edu.epam.training.railway.main.service.ItemHolder;
import edu.epam.training.railway.main.specification.Specification;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by alexey.valiev on 5/4/19.
 */
public interface RwRepository<T extends Identity> {

    void add(ItemHolder itemHolder, T item);

    void update(ItemHolder itemHolder, T item);

    void remove(ItemHolder itemHolder, T item);

    ArrayList<T> get(ItemHolder itemHolder);

    void remove(ItemHolder itemHolder, long id);

}
