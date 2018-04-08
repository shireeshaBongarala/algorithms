package com.fun.learning.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenTree {
    class Node {
        int num = 1;
        int root = -1;

    }

    public int getEvenTree(int[] treeFrom, int[] treeTo, int edges, int nodes) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            nodeList.add(new Node());
        }
        for (int i = 0; i < edges; i++) {
            nodeList.get(treeFrom[i] - 1).root = treeTo[i] - 1;
        }

        for (int i = nodes - 1; i >= 0; i--) {
            int root = nodeList.get(i).root;
            if (root >= 0) {
               Node rootNode = nodeList.get(root);
               rootNode.num  = rootNode.num + nodeList.get(i).num;
            }
        }
        int count = 0;
        for(int i = 0; i< nodes; i++){
            int root = nodeList.get(i).root;
            int num = nodeList.get(i).num;
            if(root >=0 &&  num%2==0) count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] treeNodesEdges = scanner.nextLine().split(" ");
        int treeNodes = Integer.parseInt(treeNodesEdges[0].trim());
        int treeEdges = Integer.parseInt(treeNodesEdges[1].trim());

        int[] treeFrom = new int[treeEdges];
        int[] treeTo = new int[treeEdges];

        for (int treeItr = 0; treeItr < treeEdges; treeItr++) {
            String[] treeFromTo = scanner.nextLine().split(" ");
            treeFrom[treeItr] = Integer.parseInt(treeFromTo[0].trim());
            treeTo[treeItr] = Integer.parseInt(treeFromTo[1].trim());
        }

        EvenTree evenTree = new EvenTree();
        System.out.println(evenTree.getEvenTree(treeFrom, treeTo, treeEdges, treeNodes));

    }
}
