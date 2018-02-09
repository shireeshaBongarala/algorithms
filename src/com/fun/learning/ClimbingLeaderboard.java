package com.fun.learning;

import java.util.ArrayList;
import java.util.Scanner;

public class ClimbingLeaderboard {
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        ArrayList<Integer> ranks = new ArrayList<>();
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] != scores[i + 1]) {
                ranks.add(scores[i]);
            }
        }
        if (ranks.size() == 0 || ranks.get(ranks.size() - 1) != scores[scores.length - 1]) {
            ranks.add(scores[scores.length - 1]);
        }

        for(int i = 0; i< alice.length; i++) {
        alice[i] = findRank(ranks, alice[i], 0, ranks.size()-1);
        }
        return alice;

        // Complete this function
    }

    private static int findRank(ArrayList<Integer> ranks, int score, int start, int end) {
        if(end < start) return start + 1;
        if(start < 0) return 1;
        if(start == end) {
            if(ranks.get(start) > score) return start + 2;
            else return start + 1;
        }
        int mid = (start + end)/2;

//        if(ranks.get(start) <= score) return ranks.get(start);
        if(ranks.get(mid) > score)
        return findRank(ranks, score, mid+1, end);
        if(ranks.get(mid) < score) return findRank(ranks, score, start, mid -1);
        return mid + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int scores_i = 0; scores_i < n; scores_i++) {
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for (int alice_i = 0; alice_i < m; alice_i++) {
            alice[alice_i] = in.nextInt();
        }
        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}

