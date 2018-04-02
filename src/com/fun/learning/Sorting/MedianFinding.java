package com.fun.learning.Sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinding {

    static int getNotificationCount(int[] arr, int d){
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        boolean insertIntoMinQueue = true;
        boolean deleteAtMinQueue = true;
        for (int i = 0 ; i< arr.length; i++) {
         if(insertIntoMinQueue) {
             minQueue.add(arr[i]);
         }   else {
             maxQueue.add(arr[i]);
         }
         double median = arr[0];
         if(i%2 == 0 && i> 0){
          median = maxQueue.peek();
         } else if(i>0) {
             median = (minQueue.peek() + maxQueue.peek())/2.0;
         }

            System.out.println(median + " at " + i);

            insertIntoMinQueue = !insertIntoMinQueue;
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 3, 2, 1};
        getNotificationCount(arr, 0);

    }
}
