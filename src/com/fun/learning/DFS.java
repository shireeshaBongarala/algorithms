package com.fun.learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DFS {
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

        int parent[] = new int[8];
        for(int i =0;i < parent.length; i++) parent[i] = -1;
        parent[0] = 0;
        DFS_VISIT(0, adjacenyList, parent);

        for(int i =0;i < parent.length; i++) {
            System.out.println(i + " " + parent[i]);
        }
    }

    public static void DFS_VISIT(int node, HashMap<Integer, List<Integer>> ajacencyList, int[] parent) {
        List<Integer> adj = ajacencyList.get(node);
        for (Integer i : adj) {
         if(parent[i] == -1) {
             parent[i] = node;
             DFS_VISIT(i, ajacencyList, parent);
         }
        }
    }
}
