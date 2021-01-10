package com.md.homework;

import org.junit.Test;

public class RegaxTest {

    @Test
    public void ex2() {
        String result;
        result = "The cat sat on the mat. and the cat".replaceAll("cat", "*");
        System.out.println(result);

        String pattern = "(\\w)(\\w)(\\w)(\\w)$";
        result = "01022223333".replaceAll(pattern, "$1**$4");
        System.out.println(result);


//        System.out.println("Hello     World".replaceAll(pattern, "$1-$3"));
    }
}
