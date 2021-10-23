package arrays.arraymanipulation;

import java.util.List;

import static java.lang.Math.max;
import static java.util.Arrays.asList;

//https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
class Solution {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    // This solution executes for too long but it's straightforward
    public static long resultCheck(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        long maximum = 0;
        for (List<Integer> list : queries) {
            int left = list.get(0);
            int right = list.get(1);
            int value = list.get(2);
            for (int i = left - 1; i < right; i++) {
                arr[i] += value;
                if (arr[i] > maximum) {
                    maximum = arr[i];
                }
            }
        }
        return maximum;
    }

    //this one is fast
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        long maximum = 0;
        for (List<Integer> list : queries) {
            int left = list.get(0);
            int right = list.get(1);
            int value = list.get(2);
            arr[left - 1] += value;
            if (right < n) {
                arr[right] -= value;
            }
        }

        long value = arr[0];
        maximum = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] != 0) {
                value += arr[i];
                arr[i] = value;
                maximum = max(maximum, arr[i]);
            }

        }
        return maximum;
    }

}

public class ArrayManipulation {

    public static void main(String[] args) {
        test(5, asList(1, 2, 100), asList(2, 5, 100), asList(3, 4, 100)); // 200
        test(10, asList(1, 5, 3), asList(4, 8, 7), asList(6, 9, 1)); // 10
        test(10, asList(2, 6, 8), asList(3, 5, 7), asList(1, 8, 1), asList(5, 9, 15)); // 10
    }

    static void test(int n, List<Integer>... queries) {
        System.out.println("The result is: ");
        System.out.println(Solution.arrayManipulation(n, asList(queries.clone())));
        System.out.println("Should be: ");
        System.out.println(Solution.resultCheck(n, asList(queries.clone())));
    }
}




