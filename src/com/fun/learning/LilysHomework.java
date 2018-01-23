package com.fun.learning;

import java.util.HashMap;
import java.util.Scanner;

public class LilysHomework {

    static int lilysHomework1(int[] arr) {
        // Complete this function
        int [] old = new int[arr.length];
        for(int i =0; i<arr.length; i++) {
            old[i]= arr[i];
        }
        for(int i =0;i<arr.length-1;i++) {
            for(int j =i+1;j<arr.length; j++) {
                if(arr[i]> arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        HashMap<Integer, Integer> hashMy = new HashMap();
        for(int i =0;i<arr.length; i++){
            hashMy.put(arr[i], i);
        }
        int count = 0;
        for(int i =0; i<arr.length; i++) {
            if(old[i]!= arr[i]) {
                count = count + swap(old[i], old, hashMy, count);
            }
        }
        System.out.println(count);
        return count;
    }

    static int swap(int i, int [] old, HashMap<Integer, Integer> hashMy, int count) {
        int myKey = hashMy.get(i);
        if(myKey!=i) {
            count = count + 1;
            int temp = old[myKey];
            old[myKey] = old[i];
            return swap(temp, old, hashMy, count);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = lilysHomework1(arr);
        System.out.println(result);
        in.close();
    }
}

