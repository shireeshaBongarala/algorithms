package com.fun.learning.Strings;

public class FindSubString {
    public static void main(String[] args) {
        char[] input = "abcdcd".toCharArray();
        char[] subString = "cdcd".toCharArray();
        int inpLength = input.length;
        int subLength = subString.length;
        int inpPtr = 0;
        int subPtr = 0;
        int count = 1;
        while (subPtr < subLength) {
            if (input[inpPtr] == subString[subPtr]) {
                inpPtr++;
                subPtr++;
                if (inpPtr == inpLength && subPtr < subLength) {
                    inpPtr = 0;
                    count++;
                }
            } else if (input[inpPtr] != subString[subPtr] && count == 1) {
                if (input[inpPtr] == subString[0]) {
                    subPtr = 1;
                }
                inpPtr++;
                if (inpPtr == inpLength) {
                    inpPtr = 0;
                    count++;
                }
            } else if (input[inpPtr] != subString[subPtr]) {
                count = -1;
                break;

            }
        }
        System.out.println(count);


    }
}
