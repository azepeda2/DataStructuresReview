import java.util.Arrays;

public class WaterContainer {
    public static int area(int a, int b, int aIndex, int bIndex) {
        int length = a < b ? a : b;
        int width = bIndex - aIndex;

        return length * width;
    }

    public static int[] findBiggestContainerBrute(int[] nums) {
        int[] biggestContainerIndices = { 0, 0 };
        int a, b;
        int currentMaxArea = 0;
        int calculatedArea = 0;

        for (int i = 0; i < nums.length; ++i) {
            a = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                b = nums[j];
                calculatedArea = area(a, b, i, j);
                if (calculatedArea > currentMaxArea) {
                    currentMaxArea = calculatedArea;
                    biggestContainerIndices[0] = i;
                    biggestContainerIndices[1] = j;
                }
            }
        }
        return biggestContainerIndices;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 7, 9, 2 };
        long start, stop;
        int[] answer;
        long timeElapsed;

        start = System.nanoTime();
        answer = findBiggestContainerBrute(nums);
        stop = System.nanoTime();
        timeElapsed = stop - start;
        System.out.println("Time Elapsed: in nano seconds: " + timeElapsed);
        System.out.println("Indices: " + Arrays.toString(answer));
    }
}
