package com.fun.learning.Graphs;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {


    public static void main(String args[]) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(0, 2, 5));
        edges.add(new Edge(1, 2, 3));

        int dist[] = new int[3];

        for (int i = 0; i < 3; i++) {
            dist[i] = 1000;
        }
        dist[1] = 0;

        for (int i = 0; i < 3; i++) {
            for (Edge edge : edges) {
                if (dist[edge.dest] > dist[edge.source] + edge.weight) {
                    dist[edge.dest] = dist[edge.source] + edge.weight;
                }

                if (dist[edge.source] > dist[edge.dest] + edge.weight) {
                    dist[edge.source] = dist[edge.dest] + edge.weight;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(dist[i]);
        }

    }


}
