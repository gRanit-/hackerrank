package arrays.swap;

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Solution {
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                for (int k = i + 1; k < arr.length; k++) {
                    if (arr[k] == i + 1) {
                        swap(arr, i, k);
                        swaps++;
                        break;
                    }
                }
            }
        }

        return swaps;
    }

    static void swap(int[] arr, int i, int j) {
        int value1 = arr[i];
        arr[i] = arr[j];
        arr[j] = value1;
    }
}

public class Swap {
    public static void main(String[] args) throws IOException {
        test(new int[]{1, 3, 5, 2, 4, 6, 7}); //3
        test(new int[]{1}); //0
        test(new int[]{1, 2});//0
        test(new int[]{2, 1});//1
        test(new int[]{4, 3, 1, 2});//3

        testOnFile();
    }

    static void test(int[] arr) throws IOException {
        System.out.println(Solution.minimumSwaps(arr));


    }

    static void testOnFile() throws IOException {
        File file = new File("/Users/wojciechg/Desktop/input12.txt");
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = Solution.minimumSwaps(arr);

        System.out.println(res);

        scanner.close();
    }
}
