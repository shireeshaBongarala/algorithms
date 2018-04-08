package com.fun.learning.Strings;

import java.util.Scanner;

public class Caeser {
    static String caesarCipher(String s, int k) {
        // Complete this function
        char charArray[] = s.toCharArray();
        for(int i =0; i<charArray.length; i++){
            if(Character.isLowerCase(charArray[i])){
                charArray[i] = (char) ('a' + (charArray[i]- 'a' + k)%26);
            }
            else if(Character.isUpperCase(charArray[i])){
                charArray[i] = (char) ('A' + (charArray[i]- 'A' + k)%26);
            }
        }

        return new String(charArray);

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
