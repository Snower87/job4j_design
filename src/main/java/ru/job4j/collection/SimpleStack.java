package ru.job4j.collection;

/** Класс SimpleStack реализует простой стек
 * @author Sergei Begletsov
 * @since 01.12.2021
 * @version 1
 */

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    /**
     * Метод кладет элемент на вершину стека
     * @param value - элемент
     */
    public void push(T value) {
        linked.addFirst(value);
    }

    /**
     * Метод снимает элемент с вершины стека и возвращает его
     * @return элемент с вершины стека
     */
    public T pop() {
        return linked.deleteFirst();
    }
}
