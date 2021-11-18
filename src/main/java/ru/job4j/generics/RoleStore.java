package ru.job4j.generics;

/** Класс RoleStore реализует хранилище для данных типа Role
 * @author Sergei Begletsov
 * @since 18.11.2021
 * @version 1
 */

public class RoleStore implements Store<Role> {
    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public Role findById(String id) {
        return store.findById(id);
    }
}
