package com.java.slidingWindow.variable;
import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {

    public static void main(String[] args) {
        //aabacbebebo
        System.out.println(longestSubstringWithKUniqueCharacters("aabacbebebo", 3));
    }

    private static int longestSubstringWithKUniqueCharacters(String string, int k) {

        int start = 0, end = 0;
        int n = string.length();
        int size = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        while (end < n) {
            map.put(string.charAt(end), map.getOrDefault(string.charAt(end), 0) + 1);

          /*  if (count < k) {
                count = map.size();
                end++;
            } else*/ if (map.size() == k) {
                size = Math.max(size, end - start + 1);
                end++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    if (map.get(string.charAt(start)) > 0) {
                        map.put(string.charAt(start), map.getOrDefault(string.charAt(start),0) - 1);
                        if (map.get(string.charAt(start)) == 0) {
                            map.remove(string.charAt(start));
                         //   count--;
                        }
                        start++;
                    }
                }
                end++;
            }else end++;
        }
        return size;
    }
}
