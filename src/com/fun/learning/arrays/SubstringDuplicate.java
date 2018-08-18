package com.fun.learning.arrays;

public class SubstringDuplicate {
  public static void main(String[] args) {
    lengthOfLongestSubstring("abeceeee");
  }
  public static int lengthOfLongestSubstring(String s) {
    int[] lastSeen = new int[26];

    int end = 0;
    int max = 0;

    for(int i =0; i< s.length(); i++){
      char c = s.charAt(i);
      if(lastSeen[c - 'a']!= -1 && lastSeen[c - 'a'] <= end){
        end = lastSeen[c - 'a'] + 1;
        max = Math.max(max, i - end + 1);
        lastSeen[c - 'a'] = i;
      } else {
        lastSeen[c -'a'] = i;
      }
    }
    return max;

  }
}
