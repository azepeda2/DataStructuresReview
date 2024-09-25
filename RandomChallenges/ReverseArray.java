import java.util.Arrays;
import java.util.List;

public class ReverseArray {
    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        int start, end;

        for (List<Integer> ops : operations) {
            System.out.println("Operations: " + ops.toString());
            start = ops.get(0);
            end = ops.get(1);

            swap(arr, start, end);

            /*
             * int currentRevIndex = 0;
             * for (int i = start; i <= end; ++i) {
             * reversed = new int[end - start];
             * reversed[currentRevIndex] = arr.get(i);
             * }
             *
             * 
             * List<Integer> reversed = arr.subList(start, end);
             * 
             * System.out.println("Reversed: " + reversed.toString());
             * currentRevIndex = 0;
             * for (int i = end - 1; i >= start; --i) {
             * arr.set(i, reversed.get(currentRevIndex));
             * ++currentRevIndex;
             * }
             */

            System.out.println("Array after op: " + arr.toString());
        }

        return arr;
    }

    public static void swap(List<Integer> arr, int start, int end) {
        while (start < end) {
            Integer temp = arr.get(end);
            arr.set(end, arr.get(start));
            arr.set(start, temp);
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        List<List<Integer>> ops = Arrays.asList(Arrays.asList(0, 9), Arrays.asList(4, 5), Arrays.asList(3, 6),
                Arrays.asList(2, 7), Arrays.asList(1, 8), Arrays.asList(0, 9));

        performOperations(arr, ops);
    }
}
