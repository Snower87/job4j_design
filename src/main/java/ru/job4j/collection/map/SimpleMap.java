package ru.job4j.collection.map;

import java.util.*;

/**
 * Класс SimpleMap реализует собственную структуру данных hashMap на базе массива (#51)
 * @param <K> - ключ
 * @param <V> - значение
 * @author Sergei Begletsov
 * @since 25.10.2022
 * @version 2
 */

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    /**
     * Добавляет объект в мапу
     * @param key - ключ
     * @param value - значение
     * @return true - место не занято, false - если место уже занято
     */
    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        /* 1) Таблица заполнена более 0.75?*/
        float currLoadFactor =  (((float) count) / (capacity));
        if (currLoadFactor >= LOAD_FACTOR) {
            expand();
        }
        /* 2) Определение индекса бакета*/
        int index = indBacket(key);
        /* 3) Бакет пустой?*/
        if (table[index] == null) {
            rsl = true;
            count++;
            modCount++;
            /* 4) Вставка объекта в мапу*/
            table[index] = new MapEntry<>(key, value);
        }
        return rsl;
    }

    public int getHashCodeForAll(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private int hash(int hashCode) {
        int h = (hashCode) ^ (hashCode >>> 16);
        return h;
    }

    private int indexFor(int hash) {
        int index = hash % (capacity);
        return index;
    }

    /**
     * Получает индекс бакета по ключу
     * @param key
     * @return
     */
    private int indBacket(K key) {
        /* 1) Преобразование ключа в число с помощью hashCode*/
        int h = key == null ? 0 : key.hashCode();
        /* 2) Вычислить хеш ключа с помощью хеш-функции*/
        int hash = hash(h);
        /* 3) Определение индекса бакета*/
        int index = indexFor(hash);
        return index;
    }

    /**
     * Расширение с рехешированием мапы
     */
    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] expandTable = new MapEntry[capacity];
        for (MapEntry<K, V> map: table) {
            if (map != null) {
                int newIndex = indexFor(hash(map.key == null ? 0 : map.key.hashCode()));
                expandTable[newIndex] = map;
            }
        }
        table = expandTable;
    }

    /**
     * Получает по ключу значение из карты
     * @param key - ключ объекта
     * @return null - в случае отсутствия значения должен возвращать, в противном случае само значение
     */
    @Override
    public V get(K key) {
        V rsl = null;
        int i = 0;
        if (Objects.nonNull(key)) {
            i = indBacket(key);
        }
        if (table[i] != null && table[i].key != null && getHashCodeForAll(table[i].key) == getHashCodeForAll(key) &&
                key != null && key.equals(table[i].key)) {
            rsl = table[i].value;
        }
        if (table[i] != null && table[i].key == null && getHashCodeForAll(table[i].key) == getHashCodeForAll(key) &&
                 key == null) {
            rsl = table[i].value;
        }

        return rsl;
    }

    /**
     * Удаляет по ключу значение из мапы
     * @param key - ключ объекта
     * @return true - в случае успешного удаления, в противном случае false
     */
    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int i = 0;
        if (Objects.nonNull(key)) {
            i = indBacket(key);
        }
        if (table[i] != null && table[i].key != null && getHashCodeForAll(table[i].key) == getHashCodeForAll(key) &&
                 key != null && key.equals(table[i].key)) {
            table[i] = null;
            count--;
            modCount++;
            rsl = true;
        }
        if (table[i] != null && table[i].key == null && getHashCodeForAll(table[i].key) == getHashCodeForAll(key) &&
                key == null) {
            table[i] = null;
            count--;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < capacity && table[point] == null) {
                    point++;
                }
                return point < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}