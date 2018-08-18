package com.fun.learning.arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    int[] arr = {3, 5, 6, 2, 1, 7};
    System.out.println(getLongestSubSeq(arr));
  }

  private static int getLongestSubSeq(int[] arr) {
    HashSet<Integer> available = new HashSet<>();
    for (int a : arr) {
      available.add(a);
    }
    int max = 0;

    for (int n : arr) {
      int len = 0;

      if (available.contains(n)) {
        int left = n - 1;
        int right = n + 1;
        len = 1;
        available.remove(n);
        while (available.contains(left)) {
          len += 1;
          available.remove(left);
          left--;
        }
        while (available.contains(right)) {
          len += 1;
          available.remove(right);
          right++;
        }
        max = Math.max(max, len);
      }
    }
    return max;
  }
}
