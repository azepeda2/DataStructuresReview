import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerFrequency {
    public static List<List<Integer>> calculateFrequency(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int count;
        for (int i = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                count = map.get(map) + 1;
                map.put(arr[i], count);
            } else {
                map.put(arr[i], 1);
            }
        }

        int items = map.size();
        List<List<Integer>> frequencies = new ArrayList<List<Integer>>();

        for (int i = 0; i < items; ++i) {
            // frequencies.add(Arrays.asList())
        }

        return frequencies;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 3, 1, 2, 1 };

        List<List<Integer>> result = calculateFrequency(arr);
        System.out.println(result.toString());
    }
}
