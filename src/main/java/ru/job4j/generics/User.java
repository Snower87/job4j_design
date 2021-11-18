package ru.job4j.generics;

/** Class User класс-данных
 * @author Sergei Begletsov
 * @since 18.11.2021
 * @version 1
 */

public class User extends Base {
    public User(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
