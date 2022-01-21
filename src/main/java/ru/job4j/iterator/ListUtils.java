package ru.job4j.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

/** Класс ListUtils практика работы с методами ListIterator'а
 * @author Sergei Begletsov
 * @since 21.01.2022
 * @version 1
 */

public class ListUtils {
    /**
     * Метод вставляет элемент до индекса
     * @param list ссылка на список
     * @param index индекс элемента
     * @param value значение элемента
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    /**
     * Метод вставляет элемент после индекса
     * @param list ссылка на список
     * @param index индекс элемента
     * @param value значение элемента
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            if (iterator.previousIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.previous();
        }
    }

    /**
     * Метод удаляет все элементы, которые удовлетворяют заданному предикату
     * @param list ссылка на список
     * @param filter условия для удаления
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.remove();
            }
        }
    }

    /**
     * Метод заменяет все элементы, которые удовлетворяют предикату
     * @param list ссылка на список
     * @param filter условия для удаления
     * @param value значение элемента
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.set(value);
            }
        }
    }

    /**
     * Метод удаляет из списка те элементы, которые есть в elements
     * @param list ссылка на список
     * @param elements список элементов под удаление
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            list.remove(elements.get(i));
        }
    }
}
