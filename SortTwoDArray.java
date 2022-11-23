import java.util.Arrays;
import java.util.Map;

public class SortTwoDArray {
    public static List<List<Integer>> sort(int[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

        for (int val : arr) {
            if (freqMap.containsKey(val) {
                freqMap.put(val, freqMap.get(val) + 1);
            } else {
                freqMap.put(val, 1);
            }
        }

        Set<Integer> keys = freqMap.keySet();
        
        for (Integer key : keys) {
            ArrayList<Integer> list = new ArrayList();
            list.add(freqMap.get(key));
            list.add(key);
        }


    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 2, 3};

        System.out.println(Arrays.toString(sort(arr)));
    }
}
