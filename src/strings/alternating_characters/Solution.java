package strings.alternating_characters;

import java.io.*;


class Result {
//https://www.hackerrank.com/challenges/alternating-characters/problem?isFullScreen=true
    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
        char[] chars = s.toCharArray();
        int deletionCount = 0;
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if ((i + 1) < chars.length) {
                if (chars[i + 1] == current) {
                    deletionCount++;
                }
            }
        }

        return deletionCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        String s1 = "AAAABBABABB";
        assert Result.alternatingCharacters(s1) == 5;

        String s2 = "AAAA";
        assert Result.alternatingCharacters(s2) == 3;

        String s3 = "A";
        assert Result.alternatingCharacters(s3) == 0;

        String s4 = "AB";
        assert Result.alternatingCharacters(s4) == 0;

        String s5 = "BBA";
        assert Result.alternatingCharacters(s5) == 1;

        String s6 = "ABABABABBABA";
        assert Result.alternatingCharacters(s6) == 1;

    }
}
