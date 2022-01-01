package ru.job4j.collection;

/** Класс SimpleQueue реализует очередь на двух стеках
 * @author Sergei Begletsov
 * @since 03.12.2021
 * @version 2
 */

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<T>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Метод возвращает первое значение и удаляет его из коллекции
     * @return первое значение элемента
     */
    public T poll() {
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
