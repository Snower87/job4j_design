package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterLastWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 250, 3);
    }

    @Test
    public void whenRemoveAll5() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 5, 0, 1, 2, 5));
        ListUtils.removeIf(input, num -> num == 5);
        assertThat(input, is(Arrays.asList(0, 1, 2)));
    }

    @Test
    public void whenNoOneRemove() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 5, 0, 1, 2, 5));
        ListUtils.removeIf(input, num -> num < 0);
        assertThat(input, is(Arrays.asList(5, 5, 0, 1, 2, 5)));
    }

    @Test
    public void whenSetAllElem3() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 5, 0, 1, 2, 5));
        ListUtils.replaceIf(input, num -> num >= 0, 3);
        assertThat(input, is(Arrays.asList(3, 3, 3, 3, 3, 3)));
    }

    @Test
    public void whenRemoveAllElements4() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 5, 0, 1, 2, 5));
        ListUtils.removeAll(input, Arrays.asList(4, 4, 4, 4));
        assertThat(input, is(Arrays.asList(5, 5, 0, 1, 2, 5)));
    }

    @Test
    public void whenRemoveAllCurrMassiv() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 5));
        ListUtils.removeAll(input, Arrays.asList(5, 0, 2));
        assertThat(input, is(Arrays.asList(1)));
    }
}