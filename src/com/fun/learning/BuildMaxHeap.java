package com.fun.learning;

public class BuildMaxHeap {
    public static void main(String[] args) {
        int n = 10;
        int[] array = {7, 8, 5, 9, 2, 4, 15, 20, 1, 3};

        buildMaxHeap(n, array);

        int[] sortedArray = new int[10];
        for (int i = n - 1; i >= 0; i--) {
            sortedArray[i] = array[n-i-1];
            array[n-i-1] = array[i];
            buildMaxHeap(i, array);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    private static void buildMaxHeap(int n, int[] array) {
        for (int i = n / 2; i >= 0; i--)
            maxHeapify(array, i, n);
    }

    private static void maxHeapify(int[] array, int i, int n) {
        int size = n;
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int largest = i;
        if (leftChild <= size && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild <= size && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        int temp = array[i];
        array[i] = array[largest];
        array[largest] = temp;

        if (largest > i) {
            maxHeapify(array, largest, n);
        }
    }
}
