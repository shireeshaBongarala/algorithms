package com.fun.learning.Sorting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class JourneyToTheMoon {
    static int journeyToMoon(int n, int[][] astronaut) {
        // Complete this function

        int group[] = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }

        for (int i = 0; i < astronaut.length; i++) {
            int astrounaut1Group = group[astronaut[i][0]];
            int astrounaut2Group = group[astronaut[i][1]];
            int min = Math.min(astrounaut1Group, astrounaut2Group);
            int max = Math.max(astrounaut2Group, astrounaut1Group);
            if (min!= max) {
                for (int k = 0; k < n; k++) {
                    if(group[k] == max){
                        group[k] = min;
                    }
                }
            }
        }


        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0; i<group.length; i++){
            if(h.containsKey(group[i])){
                h.put(group[i], h.get(group[i]) + 1);
            } else {
                h.put(group[i], 1);
            }
        }
        Integer[] answer = h.values().toArray(new Integer[h.size()]);
        int count = 0;
        for(int i = 0; i< answer.length-1; i++) {
            for(int j = i+1; j< answer.length; j++){
                count += answer[i]*answer[j];
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] astronaut = new int[p][2];
        for (int astronaut_i = 0; astronaut_i < p; astronaut_i++) {
            for (int astronaut_j = 0; astronaut_j < 2; astronaut_j++) {
                astronaut[astronaut_i][astronaut_j] = in.nextInt();
            }
        }
        int result = journeyToMoon(n, astronaut);
        System.out.println(result);
        in.close();
    }
}
