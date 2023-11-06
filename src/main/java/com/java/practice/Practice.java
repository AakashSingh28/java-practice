package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {


    public static void main(String[] args) {
        String s=" This is is name name";

       /* List.of(s.split(" ")).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((s1, aLong) -> {
                    System.out.println(s1 +" "+aLong);
                });*/


        List<Integer> list = Arrays.asList(1,2,3,4,9,9,94,1);

        list.forEach(integer -> {
            System.out.println(integer);
            list.remove(5);
        });
    }
}


