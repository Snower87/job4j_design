package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/** Класс SimpleArrayList реализует динамический массив
 * @author Sergei Begletsov
 * @since 27.11.2021
 * @version 2
 */

public class SimpleArrayList<T> implements List<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private void capacity(int nextSize) {
        int oldSize = container.length;
        if (oldSize == nextSize) {
            int newCapacity = oldSize * 2;
            T[] newContainer = (T[]) new Object[newCapacity];
            System.arraycopy(container, 0, newContainer, 0, size);
            container = newContainer;
        }
    }

    @Override
    public void add(T value) {
        capacity(size + 1);
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T rsl = get(index);
        container[index] = newValue;
        return rsl;
    }

    @Override
    public T remove(int index) {
        T rsl = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - size - 1);
        container[container.length - 1] = null;
        size--;
        modCount++;
        return rsl;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }
}
