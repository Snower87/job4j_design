package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/** Класс EvenNumbersIterator перебирает четные числа массива
 * @author Sergei Begletsov
 * @since 09.11.2021
 * @version 1
 */

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int indexHasNext = 0;
    private int indexNext = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (indexHasNext < data.length) {
            if (data[indexHasNext] % 2 == 0) {
                indexHasNext++;
                return true;
            }
            indexHasNext++;
        }
        return false;
    }

    @Override
    public Integer next() {
        while (indexNext < data.length) {
            if (data[indexNext] % 2 == 0) {
                return data[indexNext++];
            }
            indexNext++;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        throw new UnsupportedOperationException();
    }
}
