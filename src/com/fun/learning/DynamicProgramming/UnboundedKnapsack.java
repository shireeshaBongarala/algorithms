package com.fun.learning.DynamicProgramming;

import java.util.Scanner;

public class UnboundedKnapsack {

    static int unboundedKnapsack(int k, int[] arr, int index) {
        int size = arr.length;
        if (index >= size) {
            return k;
        }

        if(k > arr[index]){
            return Math.min(unboundedKnapsack(k-arr[index], arr, index), unboundedKnapsack(k, arr, index+1));
        } else if( k == arr[index]){
            return 0;
        } else {
            return Math.min(k, unboundedKnapsack(k, arr, index+1));
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i =0; i< t;i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int result = k - unboundedKnapsack(k, arr, 0);
            System.out.println(result);
        }
        in.close();
    }
}
