package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SimpleSetTest {
    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddNotNullTwo() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.contains(2));
        assertTrue(set.add(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenThrowException() {
        Set<Integer> set = new SimpleSet<>();
        Iterator iterator = set.iterator();
        iterator.next();
    }

    @Test
    public void whenIterableCollectionAndNotThrowException() {
        Set<Integer> set = new SimpleSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        Iterator iterator = set.iterator();
        assertEquals(10, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(30, iterator.next());
        assertFalse(iterator.hasNext());
    }
}