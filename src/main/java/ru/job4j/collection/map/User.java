package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Anton", 2, new GregorianCalendar(1982, Calendar.AUGUST, 30));
        User user2 = new User("Anton", 2, new GregorianCalendar(1982, Calendar.AUGUST, 30));
        Map<User, Object> hashMap = new HashMap<>();
        hashMap.put(user1, new Object());
        hashMap.put(user2, new Object());
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
    }
}
