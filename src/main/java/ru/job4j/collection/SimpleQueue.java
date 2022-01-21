package ru.job4j.collection;

import java.util.NoSuchElementException;

/** Класс SimpleQueue реализует очередь на двух стеках
 * @author Sergei Begletsov
 * @since 03.12.2021
 * @version 3
 */

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<T>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Метод возвращает первое значение и удаляет его из коллекции
     * @return первое значение элемента
     */
    public T poll() {
        if (in.isEmpty() && out.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Метод помещает значение в конец
     * @param value значение элемента
     */
    public void push(T value) {
        in.push(value);
    }
}
