package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс BackwardArrayIt перебирает элементы массива в обратном порядке
 * @author Sergei Begletsov
 * @since 06.11.2021
 * @version 2
 */

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        point = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
