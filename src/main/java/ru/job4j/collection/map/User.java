package ru.job4j.collection.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    // the "rehash" function in JAVA 8 that directly takes the key
    final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // the function that returns the index from the rehashed hash
    int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public static void main(String[] args) {
        Calendar dateBirth = new GregorianCalendar(1982, Calendar.AUGUST, 30);
        dateBirth.set(Calendar.MILLISECOND, 29);
        User user1 = new User("Anton", 2, dateBirth);
        User user2 = new User("Anton", 2, dateBirth);
        User user3 = new User("Anton", 2, dateBirth);
        Map<User, Object> hashMap = new HashMap<>();
        hashMap.put(user1, new Object());
        hashMap.put(user2, new Object());
        hashMap.put(user3, new Object());
        System.out.println(hashMap);
        for (User user: hashMap.keySet()) {
            System.out.println("user:" + user);
            System.out.println("value:" + hashMap.get(user) + "\n");
        }

        System.out.format("user1 hashCode (в hex) = %05x \n", user1.hashCode());
        System.out.println("user1 hashCode (в 10) = " + user1.hashCode());
        int h1 = user1.hashCode() ^ user1.hashCode() >>> 16;
        System.out.println("user1 hash = " + h1);
        int i1 = (16 - 1) & h1;
        System.out.println("Индекс бакета user1 = " + i1 + "\n");

        System.out.format("user2 hashCode (в hex) = %05x \n", user2.hashCode());
        System.out.println("user2 hashCode (в 10) = " + user2.hashCode());
        int h2 = user2.hashCode() ^ user2.hashCode() >>> 16;
        System.out.println("user2 hash = " + h2);
        int i2 = (16 - 1) & h2;
        System.out.println("Индекс бакета user2 = " + i2);
        System.out.println();

        System.out.format("user3 hashCode (в hex) = %05x \n", user3.hashCode());
        System.out.println("user3 hashCode (в 10) = " + user3.hashCode());
        int h3 = user3.hash(user3);
        System.out.println("user3 hash = " + h3);
        int i3 = user3.indexFor(h3, 16);
        System.out.println("Индекс бакета user3 = " + i3);
        System.out.println();

        Object x = hashMap.get(user1);
        System.out.println("Size map: " + hashMap.size());
        System.out.println(hashMap.keySet());
    }
}
