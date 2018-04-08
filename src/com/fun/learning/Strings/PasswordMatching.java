package com.fun.learning.Strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMatching {
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        Pattern digits = Pattern.compile("(\\d)");
        Pattern lowerCase = Pattern.compile("([A-Z])");
        Pattern upperCase = Pattern.compile("([a-z])");
        Pattern special = Pattern.compile("(\\W)");
        System.out.println(special);

        int count = 0;
        if(!special.matcher(password).find()) count++;
        if(!upperCase.matcher(password).find()) count++;
        if(!lowerCase.matcher(password).find()) count++;
        if(!digits.matcher(password).find()) count++;

        if((count + n) < 6) count = count + 6 - (count+n);
        return count;


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
//7
//AUzs-nV