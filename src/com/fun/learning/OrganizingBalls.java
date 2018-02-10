package com.fun.learning;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizingBalls {

    static String organizingContainers(int[][] container) {
        // Complete this function
        int n = container[0].length;

        int balls[] = new int[n];
        int buckets[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buckets[i] += container[i][j];
                balls[i] += container[j][i];
            }
        }
        Arrays.sort(balls);
        Arrays.sort(buckets);
        int i = 0;
        for (i = 0; i < n; i++) {
            if (buckets[i] != balls[i]) {
                return ("Impossible");

            }
        }
        return "Possible";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[][] container = new int[n][n];
            for (int container_i = 0; container_i < n; container_i++) {
                for (int container_j = 0; container_j < n; container_j++) {
                    container[container_i][container_j] = in.nextInt();
                }
            }
            String result = organizingContainers(container);
            System.out.println(result);
        }
        in.close();
    }
}
