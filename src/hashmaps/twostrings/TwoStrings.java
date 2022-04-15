package hashmaps.twostrings;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        Set<Character> chars = new HashSet<>();

        for (char c : s1.toCharArray()) {
            chars.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (chars.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }
}
