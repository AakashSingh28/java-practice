package com.java.slidingWindow.variable;

import java.util.HashMap;

public class LongestSubstringWithWithoutRepeatingCharacters {


    public static void main(String[] args) {
        //aabacbebebo
        System.out.println(longestSubstringWithWithoutRepeatingCharacters("aabacbebebo"));
    }

    private static int longestSubstringWithWithoutRepeatingCharacters(String str){
    int start = 0, end = 0, max = 0;
    HashMap<Character, Integer> map = new HashMap<>();

        while (end < str.length()) {
        map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
        int count = map.get(str.charAt(end));

        if (count == 1) {
            max = Math.max(max, map.size());
            end++;
        } else if (count > 1) {
            map.remove(str.charAt(start));
            start++;
        } else {
            end++;
        }
    }
        return max;
    }
}
