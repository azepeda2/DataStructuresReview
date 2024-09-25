import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
    public static Integer mostFreq(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        Integer mostFreq = null;
        int maxCount = -1;

        for (int num : arr) {
            if (!counts.containsKey(num))
                counts.put(num, 1);
            else
                counts.put(num, counts.get(num) + 1);

            if (counts.get(num) > maxCount) {
                maxCount = counts.get(num);
                mostFreq = num;
            }
        }

        return mostFreq;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 1, 3, 2, 1 };

        System.out.println("Most Frequent: " + mostFreq(arr));
    }
}
