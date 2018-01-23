package com.fun.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> adjacenyList = new HashMap<>();
        adjacenyList.put(0, Arrays.asList(1, 2));
        adjacenyList.put(1, Arrays.asList(0, 3, 4));
        adjacenyList.put(2, Arrays.asList(0, 3));
        adjacenyList.put(3, Arrays.asList(2, 1, 5));
        adjacenyList.put(4, Arrays.asList(1, 5, 6));
        adjacenyList.put(5, Arrays.asList(3, 4));
        adjacenyList.put(6, Arrays.asList(4));
        adjacenyList.put(7, Arrays.asList());


        HashMap<Integer, Integer> distance = new HashMap<>();
        ArrayList<Integer> allVerticesFromSource = new ArrayList<>();
        allVerticesFromSource.addAll(adjacenyList.get(0));
        for (Integer integer : allVerticesFromSource) {
            distance.put(integer, 0);
        }

        int i = 0;
        while (i < allVerticesFromSource.size()) {
            int currentVertex = allVerticesFromSource.get(i);
            if (!adjacenyList.get(currentVertex).isEmpty()) {
                for (Integer integer : adjacenyList.get(currentVertex)) {
                    distance.put(integer, distance.get(currentVertex) + 1);
                }
            }
            i++;
        }

        for (Integer integer : distance.keySet()) {
            System.out.println("Distance of " + integer + " is at " + distance.get(integer));
        }


    }
}
