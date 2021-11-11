package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс FlatMap перебирает элементы вложенного Iterator'а
 * @author Sergei Begletsov
 * @since 11.11.2021
 * @version 1
 */

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (!cursor.hasNext() && data.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }
}