package com.fun.learning;

import java.util.Scanner;

public class MaxHeapify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = n / 2; i >= 0; i--) {
            heapify(i, array);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void heapify(int root, int[] array) {
        if (hasNoLeftChild(root, array.length - 1)) {
            return;
        }
        int left_child_index = 2 * root + 1;
        int right_child_index = 2 * root + 2;


        if (array[left_child_index] > array[root]) {
            swap(left_child_index, root, array);
        }
        if (array[right_child_index] > array[root]) {
            swap(right_child_index, root, array);
        }

        heapify(left_child_index, array);
        heapify(right_child_index, array);
    }

    private static void swap(int left_child_index, int root, int[] array) {
        int x = array[left_child_index];
        array[left_child_index] = array[root];
        array[root] = x;
    }

    private static boolean hasNoLeftChild(int root, int length) {

        return (2 * root + 1) - length > 0;
    }
}
