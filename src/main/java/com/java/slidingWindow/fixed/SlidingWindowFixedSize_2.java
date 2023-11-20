package com.java.slidingWindow.fixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowFixedSize_2 {

    private static int[] firstNegativeIntegerInEverySubArraySlidingWindow(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        Queue<Integer> negatives = new LinkedList<>();

        int left = 0, right = 0;
        int ptr = 0;

        while (right < arr.length) {
            int ele = arr[right];
            if (ele < 0) {
                negatives.add(ele);
            }
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                if (negatives.isEmpty()) {
                    ans[ptr++] = 0;
                } else {
                    ans[ptr++] = negatives.peek();
                    // if the top most element is same as the left most element
                    // then also remove it from the queue
                    if (arr[left] == negatives.peek()) {
                        negatives.remove();
                    }
                }
                left++;
                right++;
            }
        }
        return ans;
    }
    private static int[] firstNegativeIntegerInEverySubArrayBruteForce(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i <= arr.length-k; i++) {
            for (int j = i; j < i+k; j++) {
                if(arr[j] < 0){
                    result.add(arr[j]);
                    break;
                }
            }
        }
        return result.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
       // int[] arr = {2, -1, 3, -4, 5, -3, 2, 6, -5, 1};
        int[] arr = {-2, -1, -3,5};
        int k = 3;
        System.out.println("firstNegativeIntegerInEverySubArrayBruteForce ");
        Arrays.stream(firstNegativeIntegerInEverySubArrayBruteForce(arr, k)).forEach(System.out::print);
        System.out.println();
        System.out.println("firstNegativeIntegerInEverySubArraySlidingWindow ");
        Arrays.stream(firstNegativeIntegerInEverySubArraySlidingWindow(arr, k)).forEach(System.out::print);
    }

}
