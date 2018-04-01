package com.fun.learning.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class GridOrdering {

    static String gridOrder(String[] grid) {
        char[][] array = new char[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {

            char[] gridChar = grid[i].toCharArray();
            Arrays.sort(gridChar);
           array[i] = gridChar;
        }
        boolean isYes =true;
        for(int i =0 ; i< grid.length; i++) {
          for(int j = 1; j< grid.length; j++){
              if(array[j-1][i] > array[j][i]) {
                isYes= false;
                break;
              }
          }
          if(!isYes) break;
        }

        if(isYes) return "YES" ;
        return "NO";
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0 ;i < t; i++){
            int n = in.nextInt();
            String[] grid = new String[n];
            for (int grid_i = 0; grid_i < n; grid_i++) {
                grid[grid_i] = in.next();
            }
            String result = gridOrder(grid);
            System.out.println(result);
        }
        in.close();
    }
}
