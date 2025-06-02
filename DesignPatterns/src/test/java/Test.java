package com.example.demo.advices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

       mergeAlternately("ab" , "pqrs");
       gcdOfStrings("ABCABC", "ABC");
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());
        int len1 = word1.length();
        int len2 = word2.length();

        for (int i = 0; i < Math.max(len1, len2); i++) {
            if (i < len1) sb.append(word1.charAt(i));
            if (i < len2) sb.append(word2.charAt(i));
        }

        return sb.toString();
    }

    public static String gcdOfStrings(String str1, String str2) {
        String concatStr1 = str1 + str2;
        String concatStr2 = str2 + str1;
        String gcd = "";

        if (concatStr1.equals(concatStr2)) {
            int x = gcd(str1.length(), str2.length());
            gcd = concatStr1.substring(0, x);

        }
        return gcd;

    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int max = 0;

        for(int candy : candies){
            if(candy > max)
                max = candy;
        }

        for(int candy : candies){
            result.add(candy + extraCandies >= max);
        }

        return result;

    }

}
