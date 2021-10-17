package left_rotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int n = a.size();

        if ((d % a.size()) == 0) { // the array after rotation is the same as initial array
            return a;
        }
        if (d < n) {
            return rotateBySplitting(a, d);
        }

        int numberOfNinD = d / n;
        int remainingRotations = d - (numberOfNinD * n);

        return rotateBySplitting(a, remainingRotations);
    }

    /**
     *  the d rotations will result in dividing array in two parts and
     *  moving right part to the left and left in the previous right
     */
    private static List<Integer> rotateBySplitting(List<Integer> a, int d) {
        List<Integer> newList = new ArrayList<>(a.size());
        for (int i = d; i < a.size(); i++) { // move right part to the left
            newList.add(a.get(i));
        }
        for (int i = 0; i < d; i++) { // move left part in the place of right
            newList.add(a.get(i));
        }
        return newList;
    }
}

public class LeftRotation {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(Result.rotLeft(arr, 4)); // 5,1,2,3,4
        System.out.println(Result.rotLeft(arr, 11)); // 2,3,4,5,1
    }
}
