package strings.beautiful_binary_string;

import java.io.IOException;

class Result {

    /*
    https://www.hackerrank.com/challenges/beautiful-binary-string/problem?isFullScreen=true
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */

    public static int beautifulBinaryString(String b) {
        final char ZERO = '0';
        final char ONE = '1';
        int changes = 0;
        System.out.println("input: " + b);
        char[] chars = b.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ((i + 2) < chars.length) {
                if ((chars[i] == ZERO) && ((chars[i + 1]) == ONE) && ((chars[i + 2]) == ZERO)) {
                    chars[i + 2] = ONE;
                    changes++;
                    i = i + 2;
                }
            }
        }
        return changes;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        System.out.println("case 1");
        String s1 = "0101101010";
        assert Result.beautifulBinaryString(s1) == 2;

        System.out.println("case 2");
        String s2 = "010010";
        assert Result.beautifulBinaryString(s2) == 2;

        System.out.println("case 3");
        String s3 = "010101";
        assert Result.beautifulBinaryString(s3) == 1;

        System.out.println("case 4");
        String s4 = "0100101010";
        assert Result.beautifulBinaryString(s4) == 3;

        System.out.println("case 5");
        String s5 = "0";
        assert Result.beautifulBinaryString(s5) == 0;

        System.out.println("case 6");
        String s6 = "0001000";
        assert Result.beautifulBinaryString(s6) == 1;

        System.out.println("case 7");
        String s7 = "0000";
        assert Result.beautifulBinaryString(s7) == 0;

    }
}

