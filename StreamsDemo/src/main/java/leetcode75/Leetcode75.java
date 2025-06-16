package leetcode75;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Leetcode75 {

    public static void main(String[] args) {

       mergeAlternately("ab" , "pqrs");
       gcdOfStrings("ABCABC", "ABC");
       reverseVowels("IceCreAm");
       System.out.printf(reverseVowels("IceCreAm"));


    }

    public static String reverseVowels(String s) {
        var vowels = Set.of('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U');
        var chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                // Swap vowels
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }
    /*
    public static String reverseVowels(String s) {

        //save all vowels in a char
        char[] chars = s.toCharArray();
        char[] temp = new char[s.length()];
        int count = 0;
        for(char c : chars){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                temp[count] = c;
                count++;
            }
        }
        char allVolwels[] = new char[count];
        System.arraycopy(temp, 0, allVolwels, 0, count);

        for(int i = 0, j=allVolwels.length-1 ; i < chars.length; i++){
            if( chars[i]== 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'
                    || chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U'){
                chars[i] = allVolwels[j];
                j--;
            }
        }

        return String.valueOf(chars);
    }*/

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
