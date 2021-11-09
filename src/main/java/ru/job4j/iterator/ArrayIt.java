package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс ArrayIt перебирает элементы массива в прямом порядке
 * @author Sergei Begletsov
 * @since 06.11.2021
 * @version 1
 */

public class ArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public ArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
