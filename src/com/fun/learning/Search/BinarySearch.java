package com.fun.learning.Search;

import java.util.Scanner;

public class BinarySearch {

    static int binarySearch(int V, int[] arr, int min, int max){
        int mid = (min + max)/2;
        if(arr[mid] == V) return mid;
        if(arr[mid] < V) return binarySearch(V, arr, min, mid-1);
        return binarySearch(V, arr, mid+1, max);
    }

    static int introTutorial(int V, int[] arr) {
        // Complete this function
        return binarySearch(V, arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = introTutorial(V, arr);
        System.out.println(result);
        in.close();
    }
}
