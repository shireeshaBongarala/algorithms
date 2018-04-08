package com.fun.learning.Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigIntegerSorting {

    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, (o1, o2) -> {
            if (o1.length() > o2.length()) return 1;
            if (o1.length() < o2.length()) return -1;
            for (int i = 0; i < o1.length(); i++) {
                if (o1.charAt(i) > o2.charAt(i)) return 1;
                if (o1.charAt(i) < o2.charAt(i)) return -1;
            }
            return 0;
        });

        return unsorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] unsorted = new String[n];

        for (int unsortedItr = 0; unsortedItr < n; unsortedItr++) {
            String unsortedItem = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            unsorted[unsortedItr] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print((result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println(); }
        }

        System.out.println();

        scanner.close();
    }
}
