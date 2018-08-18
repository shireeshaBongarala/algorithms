package com.fun.learning.arrays;

import com.fun.learning.MarsRover;

public class IslandCount {
  public static void main(String[] args) {

    String s = "aaabbbab";
    System.out.println(countIsland(s));
  }

  private static int countIsland(String s) {
    int i = 0;
    int count = 0;
    int freq = 0;
    int[] arr = new int[26];
    int maxFreq = 0;
    while (i < s.length() - 1) {
      freq = 1;
      while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
        i++;
      }

      arr[s.charAt(i) - 'a']+= freq;
      if (freq > maxFreq) {
        maxFreq = freq;
      }
      count++;
      i++;
    }
    if (s.charAt(s.length() - 1) != s.charAt(s.length() - 2)) {
      count++;
      arr[s.charAt(s.length() - 1)- 'a']++;
      maxFreq = Math.max(arr[s.charAt(s.length() - 1)- 'a'], maxFreq);
    }

    int sum = 0;
    for (int j = 0; j < arr.length; j++) {
      sum+= arr[j];
    }
    sum-= maxFreq - 1;
    return sum;
  }
}
