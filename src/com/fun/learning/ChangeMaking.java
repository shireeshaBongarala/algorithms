package com.fun.learning;

import java.util.Scanner;

public class ChangeMaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] denominations = new int[]{50, 20, 10};

        System.out.println(countChange(n, denominations, 0));

    }

    private static int countChange(int n, int[] denominations, int x) {
        if(n <0 || x < 0 || x>= denominations.length) return 0;
        if (n == 0) return 1;
        if (n - denominations[x] >= 0) {
            return countChange(n - denominations[x], denominations, x + 1) + countChange(denominations[x], denominations, x + 1);
        }
        return countChange(n, denominations, x + 1);
    }
}
