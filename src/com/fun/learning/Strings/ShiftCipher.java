package com.fun.learning.Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class ShiftCipher {

    static String caesarCipher(String s, int k) {
        char[] sChar = s.toCharArray();

        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < sChar.length; i++) {
            if (Character.isAlphabetic(sChar[i])) {
                characters.add(sChar[i]);
            }
        }

        int strLength = characters.size();
        char sorted[] = new char[strLength];
        for (int i = 0; i < strLength; i++) {
            int targetIndex = (i + k) % strLength;
            sorted[targetIndex] = characters.get(i);
        }

        int k1 = 0;
        for(int i = 0; i< sChar.length; i++) {
            if(Character.isAlphabetic(sChar[i])){
                sChar[i] = sorted[k1];
                k1++;
            }
        }


       return new String(sChar);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }
}
