package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

/** Класс SimpleSet реализует множество Set (уникальный набор данных)
 * @author Sergei Begletsov
 * @since 24.01.2022
 * @version 1
 */

public class SimpleSet<T> implements Set {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(Object value) {
        boolean rsl = false;
        if (!contains(value)) {
            set.add((T) value);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean contains(Object value) {
        boolean rsl = false;
        for (T obj: set) {
            if (Objects.equals(obj, value)) {
                rsl = true;
                break;
            }
        }
        return  rsl;
    }

    @Override
    public Iterator iterator() {
        return set.iterator();
    }
}
