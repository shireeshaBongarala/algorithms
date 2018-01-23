package com.fun.learning.DynamicProgramming;


import java.util.Scanner;

public class MakeChangeHR {

    static int[][] table;

    static int getWays(int sum, int[] type, int index){
        // Complete this function

        if(table[sum][index]!= -1){ return table[sum][index];}
        int size = type.length;

        if (index >= size) {
            return 0;
        }
        int count = 0;
        if(sum> type[index]) {
            count+= getWays(sum-type[index], type, index);
        } else if(type[index] == sum) {
            count+= 1;
        }
        count+= getWays(sum, type, index+1);
        table[sum][index] = count;
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        table = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;i<m;j++){
                table[i][j]= -1;
            }
        }

        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c, 0);
        System.out.println(ways);
    }
}
