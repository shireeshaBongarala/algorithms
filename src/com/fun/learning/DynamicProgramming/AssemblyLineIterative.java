package com.fun.learning.DynamicProgramming;

import static java.lang.Math.min;

public class AssemblyLineIterative {
    public static void main(String[] args) {
        int s[][] = {{7, 9, 3, 4, 8, 4}, {8, 5, 6, 4, 5, 7}};
        int t[][] = {{0, 2, 3, 1, 3, 4}, {0, 2, 1, 2, 2, 1}};

        int entry1 = 2, entry2 = 4, exit1 = 3, exit2 = 2;

        int n = 6;
        int f[][] = new int[2][n];
        f[0][0] =  s[0][0] + entry1;
        f[1][0] =  s[1][0] + entry2;


        for(int j = 1; j<n; j++) {
            f[0][j] = min(f[0][j-1], f[1][j-1] + t[0][j-1]) + s[0][j];
            f[1][j] = min(f[1][j-1], f[0][j-1] + t[1][j-1]) + s[1][j];
        }

        f[0][n-1] += exit1;
        f[1][n-1] += exit2;

        for(int i= 0; i<n;i++) {
            System.out.println(f[0][i] + " " + f[1][i]);
        }

        System.out.println(min(f[0][n-1], f[1][n-1]));
    }
}
