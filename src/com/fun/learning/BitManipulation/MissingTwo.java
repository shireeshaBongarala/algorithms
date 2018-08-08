package com.fun.learning.BitManipulation;

import java.util.Arrays;
import java.util.stream.IntStream;




public class MissingTwo {
  public static void main(String[] args) {
    int[] array = new int[] {2, 4, 3, 5, 7};

    int xored = IntStream.rangeClosed(1, array.length + 2).reduce(0, (a, b) -> a ^ b);
    int finalXored = Arrays.stream(array).reduce(xored, (a, b) -> a ^ b);
    int theRightMostXorBit = finalXored & ~(finalXored - 1);

    int countA = 0;
    int countB = 0;

    for (int i = 1; i <= array.length + 2; i++) {
      if ((i & theRightMostXorBit) == 0) {
        countA ^= i;
      } else {
        countB ^= i;
      }
    }

    for (int i = 0; i < array.length; i++) {
      if ((array[i] & theRightMostXorBit) == 0){
        countA^= array[i];
      } else {
        countB^= array[i];
      }
    }

    System.out.println(countA + " " + countB);

  }
}
