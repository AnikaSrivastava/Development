package org.example.leetcode75;

public class StringReverseWords {

    public static void main(String[] args) {
        System.out.println(StringReverseWords.reverseWords("a good   example"));
    }
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if(words[i].isBlank())
                continue;
            if (i != words.length -1 ) {
                sb.append(" ");
            }
            sb.append(words[i]);

        }

        return sb.toString();
    }
}
