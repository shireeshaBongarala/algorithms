package com.fun.learning.Search;

import java.util.Arrays;

public class PaintersPartition {
  public static void main(String[] args) {
    int[] boards = new int[] {7, 5, 6, 1, 2, 4};
    int k = 3;
    int min = Arrays.stream(boards).max().getAsInt();
    int max = Arrays.stream(boards).sum();

    int mid = (min + max) / 2;
    int count = getMaxSum(boards, min, max);

    if (count < k){
      min = mid;
      count = getMaxSum(boards, mid, max);
    } else if(count > k){
      count = getMaxSum(boards, min, mid);
    }
    
  }

  private static int getMaxSum(int[] boards, int min, int max) {
    int mid = (min + max) / 2;
    int count = 0;
    int i = 0;
    int tempSum = 0;
    int maxSum = 0;

    while (i < boards.length) {
      if (tempSum + boards[i] <= mid) {
        tempSum += boards[i];
      } else {
        count++;
        if (tempSum > maxSum) {
          maxSum = tempSum;
        }
        tempSum = 0;
      }
      i++;
    }
    return count;
  }
}
