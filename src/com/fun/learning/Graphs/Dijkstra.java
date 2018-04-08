package com.fun.learning.Graphs;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Dijkstra {

    class Node {
        int id;
        int weight;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static void main(String[] args) {

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.shortestPathProblem(3);

    }

    private int getMinimumWeightUnvisitedVertex(int[] nodeWeight, int[] visited) {
        int min = Integer.MAX_VALUE;
        int n = nodeWeight.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && nodeWeight[i] < min) {
                min = nodeWeight[i];
                index = i;
            }
        }
        return index;
    }

    private void shortestPathProblem(int n) {
        int[] nodeWeights = new int[n];
        nodeWeights[0] = 0;
        for (int i = 1; i < n; i++) {
            nodeWeights[i] = 1000;
        }

        int[] visited = new int[n];
        int[][] adjacencyMatrix = {{0, 10, 110}, {4, 0, 6}, {7, 8, 0}};

        for (int i = 0; i < n; i++) {
            int minWeightNode = getMinimumWeightUnvisitedVertex(nodeWeights, visited);
            visited[minWeightNode] = 1;
            for (int k = 0; k < n; k++) {
                if (nodeWeights[k] > (nodeWeights[minWeightNode] + adjacencyMatrix[minWeightNode][k])) {
                    nodeWeights[k] = nodeWeights[minWeightNode] + adjacencyMatrix[minWeightNode][k];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(nodeWeights[i]);
        }


    }
}
