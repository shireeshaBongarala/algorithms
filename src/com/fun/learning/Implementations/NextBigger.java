package com.fun.learning.Implementations;

import java.util.Arrays;
import java.util.Scanner;

public class NextBigger {

    /* Sample Input
5
ab
bb
hefg
dhck
dkhc
     */

    static String biggerIsGreater(String w) {
        char[] a = w.toCharArray();
        int n = a.length;
        int pointer = -1;
        for(int i = n-2; i>=0; i--){
            if(a[i] < a[i+1]){
                pointer = i;
                break;
            }
        }
        if(pointer == -1) return "no answer";
        Arrays.sort(a, pointer+1, n);
        for(int i = pointer+1; i<n; i++){
            if(a[i]> a[pointer]){
                char temp = a[i];
                a[i]= a[pointer];
                a[pointer] = temp;
                break;
            }
        }
        return new String(a);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            String w = in.next();
            String result = biggerIsGreater(w);
            System.out.println(result);
        }
        in.close();
    }
}
