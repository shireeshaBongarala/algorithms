package com.fun.learning.DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class SubStringWithString {
    static BigInteger substrings(String balls) {
        BigInteger sum = new BigInteger("0");
        while (balls.length() > 0) {

            int i = balls.length();
            while (i > 0) {
                String innerBalls = balls.substring(0, i);
                BigInteger ballsNum = new BigInteger(innerBalls);
                sum = sum.add(ballsNum);
                i--;
            }
            balls = balls.substring(1, balls.length());

        }
        return (sum.mod(new BigInteger("1000000007")));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String balls = in.next();
        BigInteger result = substrings(balls);
        System.out.println(result);

        in.close();
    }
}
