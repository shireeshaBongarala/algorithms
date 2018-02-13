package com.fun.learning.Strings;

import java.math.BigInteger;
import java.util.Scanner;

public class SeperateTheNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            separateNumbers(s);
        }
        in.close();
    }

    static void separateNumbers(String s) {
        int stringLength = s.length();

        int counter = 1;
        while (counter <= stringLength/2) {
            int pointer = counter;
                String first = s.substring(0, pointer);
            while (pointer < stringLength) {
                BigInteger firstInt = new BigInteger(first);
                BigInteger nextInt = firstInt.add(BigInteger.ONE);
                String nextIntToString = String.valueOf(nextInt);
                if(pointer + nextIntToString.length() > stringLength) break;
                String nextSubString = s.substring(pointer, pointer + nextIntToString.length());
                if (nextIntToString.equals(nextSubString)) {
                    pointer = pointer + nextIntToString.length();
                    first = nextIntToString;
                } else {
                    break;
                }
            }
            if(pointer == stringLength) break;
            counter++;
        }
        if(counter <= stringLength/2) System.out.println("YES " + s.substring(0, counter));
        else System.out.println("NO");
    }

}
