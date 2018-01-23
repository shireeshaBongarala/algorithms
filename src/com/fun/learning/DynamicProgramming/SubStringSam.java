package com.fun.learning.DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class SubStringSam {
    static BigInteger substrings(BigInteger balls) {
        BigInteger sum = new BigInteger("0");
        BigInteger bif = new BigInteger("0");
        while(balls.compareTo(bif) > 0 ) {
            BigInteger i = new BigInteger("10");
            while( balls.mod(i).compareTo(balls) < 0) {
                sum = sum.add(balls.mod(i).mod(new BigInteger("1000000007")));
                System.out.println(balls.mod(i));
                i = i.multiply(new BigInteger("10"));
            }
            sum  = sum.add(balls.mod(new BigInteger("1000000007")));
            System.out.println(balls);

            balls = balls.divide(new BigInteger("10"));
        }
        return (sum.mod(new BigInteger("1000000007")));
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String balls = in.next();
//        BigInteger balls = in.nextBigInteger();
//        BigInteger result = substrings(balls);
//        System.out.println(result);

        int s = in.nextInt();
        System.out.println(s);
        in.close();
    }
}
