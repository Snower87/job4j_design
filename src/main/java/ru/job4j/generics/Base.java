package ru.job4j.generics;

/** Класс Base базовая модель для всех классов
 * @author Sergei Begletsov
 * @since 18.11.2021
 * @version 1
 */

public abstract class Base {
    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}