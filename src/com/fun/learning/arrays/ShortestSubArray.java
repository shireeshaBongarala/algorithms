package com.fun.learning.arrays;

public class ShortestSubArray {
  public static void main(String[] args) {
    int arr[] = {8, -2, 3, 4, 5};
    int K = 12;
    System.out.println(shortestSubarray(arr, K));
  }

  public static int shortestSubarray(int[] arr, int K) {
    int forward = 0, back= 0, minLength = arr.length+ 1;
    int sum = 0;

    while(forward < arr.length){
      if(isAValidSubString(sum + arr[forward], K)){
        sum += arr[forward];
        while(sum - arr[back] >= K){
          sum-= arr[back];
          back++;
        }
        minLength = Math.min(minLength, forward - back + 1);
        forward++;
      } else if(isANegativeSum(sum + arr[forward])) {
        sum = 0;
        forward++;
        back = forward;
      } else {
        sum+= arr[forward];
        forward++;
      }
    }

    if(minLength <= arr.length) return minLength;
    return -1;
  }

  static boolean isANegativeSum(int sum) {
    return sum < 0;
  }

  static boolean isAValidSubString(int sum, int K) {
    return sum >= K;
  }
}
