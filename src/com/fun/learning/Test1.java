package com.fun.learning;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String... args) throws Exception {

//        Temp temp1 = new Temp("a", "b", "1");

        List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        List<String> list2 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F"));
        Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());


        Stream.concat(list1.stream(), list2.stream());
        System.out.println(new Test1().intersection(list1, list2));
        System.out.println(new Test1().union(list1, list2));
    }




    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

    public class Temp {
        public Temp(String x, String y, String id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }

        String x;
        String y;
        String id;
    }
}