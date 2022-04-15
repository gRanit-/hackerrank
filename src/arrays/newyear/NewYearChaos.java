package arrays.newyear;

//https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import java.util.Arrays;
import java.util.List;

import static arrays.newyear.Result.minimumBribes;

class Result {
    public static void minimumBribes(List<Integer> q) {
        int minimumBribes = 0;
        int[] arr = new int[q.size()];

        for (int i = 0; i < q.size(); i++) {
            int id = q.get(i);
            if ((id - 1) > (i + 2)) { // more than 2 bribes
                System.out.println("Too chaotic");
                return;
            }
            if ((id - 1) > i) {
                minimumBribes += Math.abs(id - 1 - i);
            }
        }
        System.out.println(minimumBribes);
    }
}

public class NewYearChaos {
    public static void main(String[] args) {
        minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
        minimumBribes(Arrays.asList(2, 5, 1, 3, 4));
        minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
    }
}
