package com.fun.learning.DynamicProgramming;

import java.util.ArrayList;

public class ArrayPiece {
    public static void main(String[] args) {
        int arr[] = new int[] {3, 4, 7, 9, 6};

        ArrayList<String> output = makePiece(arr, 0, arr.length -1);
        for (String s : output) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> makePiece(int[] arr, int start, int end) {
        ArrayList<String> list = new ArrayList<>();
        if(start> end) return list;
        if(start == end){
            list.add("(" + arr[start] + ")");
            return list;
        }
        else {
            for(int i = start; i <= end; i++) {
                String myString = "";
                for(int j = start; j<=i; j++){
                    myString = myString + arr[j] + " ";
                }
                myString = "(" + myString + ")";

                ArrayList<String> suffix = makePiece(arr, i+1, end);
                if(suffix.isEmpty()) list.add(myString);
                for (String s : suffix) {
                    list.add(myString + s);
                }
            }
            return list;
        }
    }
}
