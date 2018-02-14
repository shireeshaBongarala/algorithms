package com.fun.learning.DynamicProgramming.Subsequences;

import java.util.Scanner;

public class Abbreviation {
    static String abbreviation(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        int[][] memo = new int[aLength][bLength];

        if (isAbbreviation(a, b, 0, 0, memo) == 1) {
            return "YES";
        } else return "NO";
    }

    private static int isAbbreviation(String a, String b, int i, int j, int[][] memo) {
        if((i>= a.length() && j<b.length()) || j> b.length()) return -1;
        if (j < b.length() && memo[i][j] != 0) return memo[i][j];
        int answer = 0;
        if (j == b.length()) {
            return  1;
        } else if (i >= a.length()) {
           return -1;
        } else if (a.charAt(i) == b.charAt(j)) {
            answer = isAbbreviation(a, b, i + 1, j + 1, memo);
        } else if (Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
            answer = Math.max(isAbbreviation(a, b, i + 1, j + 1, memo), isAbbreviation(a, b, i + 1, j, memo));
        } else if (Character.isUpperCase(a.charAt(i))) {
            answer = -1;
        } else answer = isAbbreviation(a, b, i + 1, j, memo);

        memo[i][j] = answer;
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String a = in.next();
            String b = in.next();
            String result = abbreviation(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
