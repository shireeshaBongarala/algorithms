package com.fun.learning.DynamicProgramming;



import java.util.Scanner;

public class Solution {

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

    static int equal(int[] arr) {
        // Complete this function
        int size = arr.length;

        int low = 0;
        int high = arr.length - 1;

        quickSort(arr, low, high);
//        for (int i = 0; i < size - 1; i++) {
//            for (int j = i + 1; j < size; j++) {
//                if (arr[i] > arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        int count = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i - 1] < arr[i]) {
                while (arr[i - 1] - arr[i] < 0) {
                    int diff = -arr[i-1] + arr[i];
                    if (diff >= 5) {
                        int q = diff / 5;
                        count += q;
                        for (int j = 0; j < size; j++) {
                            if (i != j) {
                                arr[j] += q * 5;
                            }
                        }
                    }

                    for (int k = 0; k < size; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                    diff = -arr[i-1] + arr[i];
                    if (diff >= 2) {
                        int q = diff / 2;
                        count += q;
                        for (int j = 0; j < size; j++) {
                            if (i != j) {
                                arr[j] += q * 2;
                            }
                        }
                    }
                    for (int k = 0; k < size; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                    diff = -arr[i-1] + arr[i];
                    if (diff >= 1) {
                        int q = diff;
                        count += q;
                        for (int j = 0; j < size; j++) {
                            if (i != j) {
                                arr[j] += q;
                            }
                        }
                    }
                    for (int k = 0; k < size; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                }
            }

        }
        return count;
    }

    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int result = equal(arr);
            System.out.println(result);
        }
        in.close();
    }
}

