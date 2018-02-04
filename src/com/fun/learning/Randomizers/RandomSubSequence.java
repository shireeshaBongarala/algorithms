package com.fun.learning.Randomizers;

import java.util.Scanner;

public class RandomSubSequence {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Scanner scanner = new Scanner(System.in);
        int n = arr.length;
        int k = 3;

        while(scanner.nextInt() != -1){
        int x = (int)(Math.random()*10) % (n-2);
        int y = (int)(Math.random()*10) % (n-1 -(x+1)) + (x+1) ;
        int z = (int)(Math.random()*10) % (n - (y+1)) + (y+1);
        System.out.println(arr[x] + " " + arr[y] + " " + arr[z]);}
    }
}
