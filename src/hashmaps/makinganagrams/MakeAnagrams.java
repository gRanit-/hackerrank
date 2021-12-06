package hashmaps.makinganagrams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Make Anagrams
    https://www.hackerrank.com/challenges/ctci-making-anagrams/
 */
class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    private static void loadMap(String word, Map<Character, Integer> map) {
        // load each Character from word and count it's occurrence
        for (int i = 0; i < word.length(); i++) {
            map.merge(word.charAt(i), 1, Integer::sum);
        }
    }

    private static int deleteDifferences(Map<Character, Integer> firstMap, Map<Character, Integer> secondMap) {
        // iterates over first map and checks if the Character exist in the secondmap
        int deletes = 0;
        Set<Character> keysToRemove = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
            Integer otherValue = secondMap.getOrDefault(entry.getKey(), 0);
            if (!entry.getValue().equals(otherValue)) {
                int val = Math.abs(entry.getValue() - otherValue);
                deletes += val;
            }
            keysToRemove.add(entry.getKey());
        }

        // remove to make second call faster
        keysToRemove.forEach(key -> {
            firstMap.remove(key);
            secondMap.remove(key);
        });

        return deletes;
    }

    public static int makeAnagram(String a, String b) {
        Map<Character, Integer> characterMapA = new HashMap<>();
        Map<Character, Integer> characterMapB = new HashMap<>();
        loadMap(a, characterMapA);
        loadMap(b, characterMapB);
        int deletes = 0;
        deletes += deleteDifferences(characterMapA, characterMapB);
        deletes += deleteDifferences(characterMapB, characterMapA);
        return deletes;
    }
}

public class MakeAnagrams {

    public static void main(String[] args) {
        System.out.println(Result.makeAnagram("abc", "abe")); // 2
        System.out.println(Result.makeAnagram("abc", "cde"));// 4
        System.out.println(Result.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke")); //30
        System.out.println(Result.makeAnagram("showman", "woman"));//2
    }

}


