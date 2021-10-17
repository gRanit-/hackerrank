package hourglass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.IntStream.rangeClosed;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        Integer maximumSum = null;
        for (int lineNumber = 0; lineNumber < 6; lineNumber++) {
            if ((lineNumber + 2) < 6) {
                for (int k = 0; k < 6; k++) {
                    if ((k + 2) < 6) {
                        maximumSum = max(maximumSum, getHourGlassSum(k, lineNumber, arr));
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return maximumSum;
    }

    private static Integer max(Integer x, Integer y) {
        if (x == null) {
            return y;
        } else if (y == null) {
            return x;
        } else {
            return (x > y) ? x : y;
        }
    }

    private static Integer getHourGlassSum(int x1, int y1, List<List<Integer>> arr) {
        int firstRow = rangeClosed(0, 2).map(it -> arr.get(y1).get(x1 + it)).sum();
        int secondRow = arr.get(y1 + 1).get(x1 + 1);
        int thirdRow = rangeClosed(0, 2).map(it -> arr.get(y1 + 2).get(x1 + it)).sum();
        return firstRow + secondRow + thirdRow;
    }

}

public class Hourglass {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList();
        arr.add(Arrays.asList(-9, -9, -9, 1, 1, 1));
        arr.add(Arrays.asList(0, -9, 0, 4, 3, 2));
        arr.add(Arrays.asList(-9, -9, -9, 1, 2, 3));
        arr.add(Arrays.asList(0, 0, 8, 6, 6, 0));
        arr.add(Arrays.asList(0, 0, 0, -2, 0, 0));
        arr.add(Arrays.asList(0, 0, 1, 2, 4, 0));

        System.out.println(Result.hourglassSum(arr)); //28

        List<List<Integer>> arr2 = new ArrayList();
        arr2.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr2.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arr2.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr2.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arr2.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arr2.add(Arrays.asList(0, 0, 1, 2, 4, 0));

        System.out.println(Result.hourglassSum(arr2)); //19
    }
}
