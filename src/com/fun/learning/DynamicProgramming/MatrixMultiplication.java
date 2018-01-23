package com.fun.learning.DynamicProgramming;

public class MatrixMultiplication {
    static int global = 0;
    public static void main(String[] args) {
        int p[] = {30, 35, 15, 5, 10, 20, 25};

        int n = p.length;
        Integer m[][] = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        int count = getMinMultiplications(1, p.length - 1, p, m);
        System.out.println(count);
    }

    private static int getMinMultiplications(int i, int j, int[] p, Integer[][] m) {

        if (i == j) return m[i][j];

        if (m[i][j] == null) {
            System.out.println(global++);
            m[i][j] = 100000;
            for (int k = i; k < j; k++) {

                m[i][j] = Math.min(
                        getMinMultiplications(i, k, p, m) +
                                getMinMultiplications(k + 1, j, p, m) + p[i - 1] * p[k] * p[j], m[i][j]);
            }
        }
        return m[i][j];
    }
}
