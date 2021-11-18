package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

/** Класс MemStore - каркас универсального хранилища
 * @author Sergei Begletsov
 * @since 18.11.2021
 * @version 1
 */

public final class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        return mem.replace(id, findById(id), model);
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(id, findById(id));
    }

    @Override
    public T findById(String id) {
        T value = null;
        for (String key: mem.keySet()) {
            if (key.equals(id)) {
                value = mem.get(key);
                break;
            }
        }
        return value;
    }
}