package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Класс MatrixIt перебирает элементы двумерного массива
 * @author Sergei Begletsov
 * @since 08.11.2021
 * @version 3
 */

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && (data[row].length == 0 || column >= data[row].length)) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}