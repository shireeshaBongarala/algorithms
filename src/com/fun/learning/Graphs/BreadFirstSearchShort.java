package com.fun.learning.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BreadFirstSearchShort {

    class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    int[] bfs(int n, int m, int[][] edges, int s) {
        s  = s-1;
        List<Edge> edgeArrayList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            Edge edge = new Edge(edges[i][0] -1 , edges[i][1] - 1, 6);
            edgeArrayList.add(edge);
        }

        int dist[] = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = 10000;
        }
        dist[s] = 0;

        for (int i = 0; i < n; i++) {
            for (Edge edge : edgeArrayList) {
                if (dist[edge.dest] > dist[edge.source] + edge.weight) {
                    dist[edge.dest] = dist[edge.source] + edge.weight;
                }

                if (dist[edge.source] > dist[edge.dest] + edge.weight) {
                    dist[edge.source] = dist[edge.dest] + edge.weight;
                }
            }
        }

        int arr[] = new int[n-1];
        int k = 0;
        for(int i = 0; i< n; i++){
            if (dist[i] != 0) {
                if(dist[i] == 10000)
                    arr[k] = -1;
                else arr[k] = dist[i];
                k++;
            }

        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][2];
            for (int edges_i = 0; edges_i < m; edges_i++) {
                for (int edges_j = 0; edges_j < 2; edges_j++) {
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }
            int s = in.nextInt();
            BreadFirstSearchShort breadFirstSearchShort = new BreadFirstSearchShort();
            int[] result = breadFirstSearchShort.bfs(n, m, edges, s);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
