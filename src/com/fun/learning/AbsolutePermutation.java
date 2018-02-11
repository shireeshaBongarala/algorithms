package com.fun.learning;

import java.util.HashSet;
import java.util.Scanner;

public class AbsolutePermutation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int answer = 0;
            HashSet values = new HashSet<Integer>();
            int arr[] = new int[n];
            int counter = 0;
            for (int i = 1; i <= n; i++) {
                int otherValue = Math.abs(i - k);
                if (!values.contains(otherValue) && k == Math.abs(otherValue - i) && otherValue <= n && otherValue > 0) {
                    arr[counter] = otherValue;
                    values.add(otherValue);
                    counter++;
                } else {
                    otherValue = Math.abs(i + k);
                    if (!values.contains(otherValue) && k == Math.abs(otherValue - i) && otherValue <= n && otherValue > 0) {
                        arr[counter] = otherValue;
                        values.add(otherValue);
                        counter++;

                    } else {
                        answer = -1;
                        break;
                    }
                }


            }
            if (answer == -1)
                System.out.println(answer);
            else {
                for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
                System.out.println();
            }


        }

    }
}
