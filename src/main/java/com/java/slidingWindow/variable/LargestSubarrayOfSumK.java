package com.java.slidingWindow.variable;

public class LargestSubarrayOfSumK {
    private static int largestSubarrayOfSumK(int[] arr, int targetSum) {
        int start = 0;
        int end = 0;
        long sum = 0;
        int maxSize = 0;

        while (end < arr.length){
            sum+=arr[end];
            if(start <= end && sum > targetSum){
                while (sum > targetSum){
                    sum -= arr[start];
                    start++;
                }
            }if(sum < targetSum){
                end++;
            }if(sum == targetSum){
                maxSize =  Math.max(maxSize,end - start +1);
                end++;
            }

        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,1,1,1,2,3,1,1,5};
        int targetSum = 5;
        System.out.println(largestSubarrayOfSumK(arr,targetSum));
    }


}
