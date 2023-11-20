package com.java.slidingWindow.fixed;
import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams {

    private static int countAnagramsSlidingWindow(String str, String pattern) {
        int patternLength = pattern.length();
        int strLength = str.length();
        int start = 0;
        int end = 0;
        int anagramCount = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Populate frequency map for the pattern
        for (char c : pattern.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int requiredCount = frequencyMap.size();

        while (end < strLength) {
            char endChar = str.charAt(end);

            // Update frequency map and requiredCount when encountering a character in the pattern
            if (frequencyMap.containsKey(endChar)) {
                frequencyMap.put(endChar, frequencyMap.get(endChar) - 1);
                if (frequencyMap.get(endChar) == 0) {
                    requiredCount--;
                }
            }

            if (end - start + 1 == patternLength) {
                // Check if all characters in the pattern are matched
                if (requiredCount == 0) {
                    anagramCount++;
                }

                char startChar = str.charAt(start);

                // Restore frequency map and requiredCount when sliding the window
                if (frequencyMap.containsKey(startChar)) {
                    frequencyMap.put(startChar, frequencyMap.get(startChar) + 1);
                    if (frequencyMap.get(startChar) == 1) {
                        requiredCount++;
                    }
                }

                start++;
            }

            end++;
        }

        return anagramCount;
    }

    public static void main(String[] args) {
        String str = "abccbabca";
        String pattern = "abc";

        System.out.println(countAnagramsSlidingWindow(str, pattern));  // Should return 3
    }
}
