package com.fun.learning.Sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinding {

    static int getNotificationCount(int[] arr, int d){
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        double median = arr[0];
        maxQueue.add(arr[0]);
        System.out.println(median + " at " + 0);
        for(int i = 1; i < arr.length; i++) {
            int minQueueSize = minQueue.size();
            int maxQueueSize = maxQueue.size();

            if(minQueueSize == maxQueueSize){
                if(arr[i] > median) {
                    minQueue.add(arr[i]);
                    median = minQueue.peek();
                } else {
                    maxQueue.add(arr[i]);
                    median = maxQueue.peek();
                }
            } else if(minQueueSize < maxQueueSize){
                if(arr[i] > median){
                    minQueue.add(arr[i]);
                    median = (minQueue.peek() + maxQueue.peek())/2.0;
                } else {
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(arr[i]);
                    median = (minQueue.peek() + maxQueue.peek())/2.0;
                }
            } else  {
                if(arr[i] > median) {
                    maxQueue.add(minQueue.poll());
                    minQueue.add(arr[i]);
                    median = (minQueue.peek() + maxQueue.peek())/2.0;
                } else {
                    maxQueue.add(arr[i]);
                    median = (maxQueue.peek() + minQueue.peek())/2.0;
                }
            }
            System.out.println(median + " at " + i);
        }


        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 3, 2, 1};
        getNotificationCount(arr, 0);

    }
}
