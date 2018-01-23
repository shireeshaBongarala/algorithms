package com.fun.learning.DynamicProgramming;

import static java.lang.Math.min;

public class AssemblyLineRecursive {
    public static void main(String[] args) {
        int s[][] = {{7, 9, 3, 4, 8, 4}, {8, 5, 6, 4, 5, 7}};
        int t[][] = {{0, 2, 3, 1, 3, 4}, {0, 2, 1, 2, 2, 1}};

        int entry1 = 2, entry2 = 4, exit1 = 3, exit2 = 2;

        int n = 6;
        int f[][] = new int[2][n];
        f[0][0] =  s[0][0] + entry1;
        f[1][0] =  s[1][0] + entry2;

        System.out.println(fastestRoute(n, 0, s, t));

    }

    private static int fastestRoute(int n, int line, int s[][], int t[][]) {
        if(n == 0) {
            return s[n][line];
        }


        return min(fastestRoute(n-1, line, s, t) + s[line][n], 0);
    }
}
