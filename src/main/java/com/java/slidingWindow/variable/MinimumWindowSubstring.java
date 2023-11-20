package com.java.slidingWindow.variable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        //aabacbebebo  "ADOBECODEBANC"
        System.out.println(minimumWindowSubstring("ADOBECODEBANC","ABC"));
    }


    // Need to fix this
    private static int minimumWindowSubstring(String str, String targetStr) {

        int start=0,end=0,min=Integer.MAX_VALUE,count = 0;
        Map<Character, Integer> targetMap = targetStr.chars().boxed().collect(Collectors.groupingBy(ch -> (char) ch.intValue(), Collectors.summingInt(e -> 1)));
        count = targetMap.size();

          while (end < str.length()){
            if(targetMap.containsKey(str.charAt(end))){
                if(targetMap.get(str.charAt(end)) > 0){
                    targetMap.put(str.charAt(end),targetMap.getOrDefault(str.charAt(end),0)-1);
                }else if(targetMap.get(str.charAt(end)) == 0){
                    count--;
                }
                else end++;
            }else if (count == 0){
                min = Math.min(min,end - start+1);
            } else if (targetMap.get(str.charAt(end)) < 0) {
                while (targetMap.get(str.charAt(end)) < 0){
                    targetMap.put(str.charAt(end),targetMap.getOrDefault(str.charAt(end),0)-1);
                    start++;
                }
            }

          }

               return min;
    }

    public String minWindow(String s, String t) {
        String ans="";
        int i=0,j=0;
        int min=Integer.MAX_VALUE;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int k=0;k<t.length();k++)
        {
            char c=t.charAt(k);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count=map.size();

        while(j<s.length())
        {
            char c=s.charAt(j);
            if(!map.containsKey(c))
            {
                j++;
                continue;
            }
            else if(map.containsKey(c))
            {
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    count--;
            }
            if(count==0)
            {
                if(min>j-i+1)
                {
                    ans=s.substring(i,j+1);
                    min=Math.min(min,j-i+1);
                }
                while(count==0)
                {
                    char c1=s.charAt(i);
                    if(!map.containsKey(c1))
                        i++;
                    else{
                        map.put(c1,map.get(c1)+1);
                        if(map.get(c1)>0)
                            count++;
                        i++;
                    }
                    if(count==0)
                    {
                        if(min>j-i+1)
                        {
                            ans=s.substring(i,j+1);
                            min=j-i+1;
                        }
                    }
                }
            }
            j++;
        }
        return ans;
    }

}
