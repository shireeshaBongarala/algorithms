package com.fun.learning.NP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSum {
    static int getSumOfSubset(int[] s, int t) {
        List<Integer> L = new ArrayList<>();
        L.add(0);
        for (int value : s) {
            List<Integer> newList = addElementToSubset(L, value);
            newList.addAll(L);
            L = newList.stream().filter(x -> x <= t).collect(Collectors.toList());
        }
        return L.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }


    private static List<Integer> addElementToSubset(List<Integer> l, int i) {
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : l) {
            newList.add(integer + i);
        }
        return newList;
    }

    public static void main(String[] args) {
        int s[] = {6,2, 3,4, 8, 7};
        System.out.println(getSumOfSubset(s, 29));

    }
}
