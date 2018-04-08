package com.fun.learning.Strings;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Anagrams {
    static int makingAnagrams(String s1, String s2) {
        // Complete this function
        char[] charA = s1.toCharArray();
        Math.sqrt()
        char[] charB = s2.toCharArray();

        HashMap<Character, Integer> mapA = new HashMap();
        for (char a : charA) {
            if (mapA.containsKey(a)) {
                int value = mapA.get(a);
                mapA.put(a, value + 1);
            } else {
                mapA.put(a, 1);
            }
        }

        HashMap<Character, Integer> mapB = new HashMap();
        for (char b : charB) {
            if (mapB.containsKey(b)) {
                int value = mapB.get(b);
                mapB.put(b, value + 1);
            } else {
                mapB.put(b, 1);
            }
        }
        int count = 0;
        for (Character c : mapA.keySet()) {
            if(mapB.containsKey(c)){
                int bkeys = mapB.get(c);
                int akeys = mapA.get(c);
                if(akeys == bkeys) {
                    mapA.put(c, 0);
                    mapB.put(c, 0);
                } else if(akeys > bkeys){
                    mapA.put(c, akeys-bkeys);
                    mapB.put(c, 0);
                } else {
                    mapA.put(c, 0);
                    mapB.put(c, bkeys- akeys);
                }
            }
        }

        for(Integer value: mapA.values()){count+= value;
        }

        for(Integer value: mapB.values()){count+= value;
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
