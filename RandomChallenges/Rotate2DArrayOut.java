import java.util.Arrays;

public class Rotate2DArrayOut {
    public static int[][] rotate(int[][] arr, int n) {
        int[][] rotatedArr = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                rotatedArr[j][n - 1 - i] = arr[i][j];
            }
        }

        return rotatedArr;
    }

    public static void printField(int[][] field) {
        for (int[] row : field) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] field1 = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        System.out.println("Original Field: ");
        printField(field1);
        System.out.println("Rotated Field: ");
        printField(rotate(field1, 3));

    }
}
