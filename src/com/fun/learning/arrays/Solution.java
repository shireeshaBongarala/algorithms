package com.fun.learning.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums.length == 0 && k == 0) return new int[0];
    int n = nums.length;
    Deque<Integer> promising = new ArrayDeque<>();
    int[] ans = new int[ n-k +1];
    for(int i =0; i < n; i++){
      while(!promising.isEmpty() && promising.peek() <= (i-k)) {
        promising.poll();
      }
      while(!promising.isEmpty() && nums[promising.peekLast()] <= nums[i]) {
        promising.pollLast();
      }
      promising.offerLast(i);
      if(i>=k-1) {
        ans[i-(k-1)] = nums[promising.peek()];
      }
    }
    return ans;

  }
}
