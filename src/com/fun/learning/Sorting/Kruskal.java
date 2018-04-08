package com.fun.learning.Sorting;


import java.util.*;
//Not complete

public class Kruskal {

    public class Edge implements Comparable {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            Edge other = (Edge) o;
            if (this.weight > other.weight) return 1;
            else if (this.weight < other.weight) return -1;
            if ((this.weight + this.source + this.dest) > (this.source + this.weight + this.dest)) return 1;
            if ((this.weight + this.source + this.dest) < (this.source + this.weight + this.dest)) return -1;
            return 0;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public void getOutput() {

        String[] gNodesEdges = scanner.nextLine().split(" ");
        int gEdges = Integer.parseInt(gNodesEdges[1].trim());

        List<Edge> edges = new ArrayList<>();
        for (int gItr = 0; gItr < gEdges; gItr++) {
            String[] gFromToWeight = scanner.nextLine().split(" ");
            int from = Integer.parseInt(gFromToWeight[0].trim());
            int to = Integer.parseInt(gFromToWeight[1].trim());
            int weight = Integer.parseInt(gFromToWeight[2].trim());
            edges.add(new Edge(from, to, weight));
        }

        Collections.sort(edges);

        Set<Integer> visitedVertexList = new HashSet<>();
        long edgeWeightCount = 0;

        for (Edge edge : edges) {
            int source = edge.source;
            int dest = edge.dest;

            if (!visitedVertexList.contains(source) || !visitedVertexList.contains(dest)) {
                visitedVertexList.add(source);
                visitedVertexList.add(dest);
                edgeWeightCount += edge.weight;
            }
        }

        System.out.println(edgeWeightCount);
    }

    public static void main(String[] args) {

        Kruskal kruskal = new Kruskal();
        kruskal.getOutput();

    }

}


