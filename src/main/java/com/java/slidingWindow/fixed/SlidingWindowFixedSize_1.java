package com.java.slidingWindow.fixed;

public class SlidingWindowFixedSize_1 {


    private static int findMaxSumOfSubArraySlidingWindow(int[] arr, int subArraySize) {
        int maxSum = 0;
        int sum = 0;
        int start=0;
        int end=0;

        while (end<arr.length){
          sum+=arr[end];
          if(end - start + 1 == subArraySize){
             maxSum = Math.max(maxSum,sum);
             sum = sum - arr[start];
             start++;
             end++;
          }else end++;

        }
        return maxSum;
    }

    // Brute force
    private static int findMaxSumOfSubArrayBruteForce(int[] arr, int subArraySize) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - subArraySize; i++) {
            int currSum = 0;

            for (int j = i; j < i + subArraySize; j++) {
                currSum += arr[j];
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 9, 7, 1};
        int subArraySize = 3;
        System.out.println("findMaxSumOfSubArraySlidingWindow "+findMaxSumOfSubArraySlidingWindow(arr, subArraySize));
        System.out.println("findMaxSumOfSubArrayBruteForce "+findMaxSumOfSubArrayBruteForce(arr, subArraySize));
    }
}
