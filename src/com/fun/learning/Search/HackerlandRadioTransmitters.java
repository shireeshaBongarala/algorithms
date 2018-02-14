package com.fun.learning.Search;

import java.util.Arrays;
import java.util.Scanner;

public class HackerlandRadioTransmitters {
    static int hackerlandRadioTransmitters(int[] arr, int range) {
        int i = 0;
        int count = 0;
        Arrays.sort(arr);
        while (i < arr.length) {
            int idealLoc = Math.min(arr[i] + range, arr[arr.length - 1]);
            while (i < arr.length && arr[i] <= idealLoc) {
                i++;
            }
            count = count + 1;
            int rightRange = Math.min(arr[i - 1] + range, arr[arr.length - 1]);
            while (i < arr.length && arr[i] <= rightRange) {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int x_i = 0; x_i < n; x_i++) {
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
}
