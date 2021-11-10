package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/** Класс EvenNumbersIterator перебирает четные числа массива
 * @author Sergei Begletsov
 * @since 09.11.2021
 * @version 3
 */

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        while (index < data.length) {
            if (data[index] % 2 == 0) {
                rsl = true;
                break;
            }
            index++;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return data[index++];
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
