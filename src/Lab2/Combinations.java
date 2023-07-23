package Lab2;

import java.util.ArrayList;
import java.util.List;

public class Combinations {


    public static List<int[]> comb(int n, int m) {
        List<int[]> pairs = new ArrayList<>();
        helper(pairs, new int[m], 0, n - 1, 0);
        return pairs;
    }

    private static void helper(List<int[]> pairsCopy, int[] data, int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            pairsCopy.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(pairsCopy, data, start + 1, end, index + 1);
            helper(pairsCopy, data, start + 1, end, index);
        }
    }
}
