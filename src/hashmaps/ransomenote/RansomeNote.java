package hashmaps.ransomenote;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

//https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class RansomeNote {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        String result = "Yes";
        Map<String, Long> wordcount = magazine.stream()
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));

        for (String word : note) {
            Long count = wordcount.computeIfPresent(word, (key, value) -> value - 1);
            if ((count == null) || (count < 0)) {
                result = "No";
                break;
            }
        }
        System.out.println(result);
    }

}
