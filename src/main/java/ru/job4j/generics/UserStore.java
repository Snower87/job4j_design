package ru.job4j.generics;

/** Класс UserStore реализует хранилище для данных типа User
 * @author Sergei Begletsov
 * @since 18.11.2021
 * @version 1
 */

public class UserStore implements Store<User> {
    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
