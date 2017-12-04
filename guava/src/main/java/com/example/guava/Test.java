package com.example.guava;

import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String strings[] = {"1", "2", null, "3"};
        List<String> list = Arrays.asList(strings);
        System.out.println(list);
    }

    public static String joinByGuava(List stringList, String delimiter) {
        return Joiner
            .on(delimiter)
            .skipNulls()
            .join(stringList);
    }

}
