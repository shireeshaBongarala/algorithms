package com.fun.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Randomizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        while (size != 0) {
            int random[] = randomizeArray(size);
            for (int i = 0; i < size; i++) {
                System.out.print(random[i] + " ");
            }
            size = scanner.nextInt();
        }

    }

    private static int[] randomizeArray(int n) {
        int size = n;
        int scrambled[] = new int[size + 1];
        int i = 0;
        List<Integer> myarr = new ArrayList<>();
        for (int k = 0; k <= size; k++) {
            myarr.add(k);
        }

        while (size >= 0) {
            int element = (int) (Math.random() * 10 % size);
            scrambled[i] = myarr.get(element);
            myarr.remove(element);
            size--;
            i++;
        }
        return scrambled;
    }
}
