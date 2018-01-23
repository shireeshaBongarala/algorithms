package com.fun.learning.DynamicProgramming;

public class MakeChange {
    public static void main(String[] args) {

        int[] type = { 1, 2, 3};
        int sum = 4;

        int count = getNoOfCoins(type, 0, sum);
        System.out.println(count);

    }

    private static int getNoOfCoins(int[] type, int index, int sum) {

        int size = type.length;

        if (index >= size) {
            return 0;
        }
        int count = 0;
        if(sum> type[index]) {
            count+= getNoOfCoins(type, index, sum-type[index]);
        } else if(type[index] == sum) {
            count+= 1;
        }
        count+= getNoOfCoins(type, index+1, sum);
        return count;
    }
}
