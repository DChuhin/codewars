package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * counts which element will be last if to remove every nth element
 */
public class JosephusSurvivor {

    public static int josephusSurvivor(final int n, final int k) {
        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        int position = k - 1;
        while (list.size() > 1) {
            while (position > list.size() - 1) {
                position -= list.size();
            }
            list.remove(position--);
            position += k;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(josephusSurvivor(11, 19));
    }
}
