package com.fun.learning.Sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinding {

    static int getNotificationCount(int[] arr, int d) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        double median = arr[0];
        maxQueue.add(arr[0]);
        System.out.println(median + " at " + 0);
        for (int i = 1; i < arr.length; i++) {
            addNumber(minQueue, maxQueue, arr[i]);
            rebalanceTree(minQueue, maxQueue);
            median = getMedian(minQueue, maxQueue);
            System.out.println(median + " at " + i);
        }
        return 0;
    }

    private static void rebalanceTree(PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue) {
        int minQueueSize = minQueue.size();
        int maxQueueSize = maxQueue.size();

        if(Math.abs(minQueueSize - maxQueueSize) <2) return;

        if(minQueueSize > maxQueueSize){
            maxQueue.add(minQueue.poll());
        } else minQueue.add(maxQueue.poll());
    }

    private static double getMedian(PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue) {
        int minQueueSize = minQueue.size();
        int maxQueueSize = maxQueue.size();

        if (minQueueSize < maxQueueSize)
            return maxQueue.peek();

        if(minQueueSize > maxQueueSize)
            return  minQueue.peek();

        return  (minQueue.peek() + maxQueue.peek())/2.0;
    }

    private static void addNumber(PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue, int number) {
        double median = getMedian(minQueue, maxQueue);
        if (number > median) {
            minQueue.add(number);
        } else maxQueue.add(number);


    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 3, 2, 1};
        getNotificationCount(arr, 0);

    }
}
