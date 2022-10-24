import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            int differenceNeeded = target - nums[i];

            for (int j = i + 1; j < nums.length; ++j) {
                if (differenceNeeded == nums[j]) {
                    return new int[] { i, j };
                }
            }
        }

        return null;
    }

    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int differenceNeeded;

        for (int i = 0; i < nums.length; ++i) {
            if (indices.containsKey(nums[i])) {
                return new int[] { indices.get(nums[i]), i };
            } else {
                differenceNeeded = target - nums[i];
                indices.put(differenceNeeded, i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 7, 9, 2 };
        int target = 11;
        long start, stop;
        int[] answer;
        long timeElapsed;

        start = System.nanoTime();
        answer = findTwoSum(nums, target);
        stop = System.nanoTime();
        timeElapsed = stop - start;
        System.out.println("Time Elapsed: in nano seconds: " + timeElapsed);
        System.out.println("Indices: " + Arrays.toString(answer));

        start = System.nanoTime();
        answer = findTwoSumBrute(nums, target);
        stop = System.nanoTime();
        timeElapsed = stop - start;
        System.out.println("Time Elapsed: in nano seconds: " + timeElapsed);
        System.out.println("BruteForce Indices: " + Arrays.toString(answer));

    }

}
