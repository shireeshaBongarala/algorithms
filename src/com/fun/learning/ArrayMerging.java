package com.fun.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayMerging {
    public static void main(String[] args) {
        List<String> preferred = Arrays.asList("pref1", "rr3");
        List<String> rr = Arrays.asList("rr1", "rr2");

//        List<String>

//        List<Simple> simple

        int pre = preferred.size() >=3 ? 3 : preferred.size();

        System.out.println( rr.stream().skip(3).collect(Collectors.toList()));

        rr.stream().map(r -> r.getBytes()).filter(preferred:: contains).collect(Collectors.toList());



        System.out.println( Stream.concat(preferred.stream().skip(3), rr.stream()).collect(Collectors.toList()));




    }
    public class Simple {
        int id;
        String name;

        public Simple(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }



}
