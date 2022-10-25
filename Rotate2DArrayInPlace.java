import java.util.Arrays;

public class Rotate2DArrayInPlace {
    public static int[][] rotate(int[][] arr, int n) {
        // n/2 gives us floor(n/2)
        // and n/2 + n%2 gives us ceiling(n/2)

        for (int i = 0; i < n / 2 + n % 2; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int[] temp = new int[4];
                int currentI = i;
                int currentJ = j;

                for (int k = 0; k < 4; ++k) {
                    temp[k] = arr[currentI][currentJ];
                    int[] coordinates = rotateSub(currentI, currentJ, n);
                    currentI = coordinates[0];
                    currentJ = coordinates[1];
                }

                for (int k = 0; k < 4; k++) {
                    arr[currentI][currentJ] = temp[(k + 3) % 4];
                    int[] coordinates = rotateSub(currentI, currentJ, n);
                    currentI = coordinates[0];
                    currentJ = coordinates[1];
                }

            }
        }

        return arr;
    }

    public static int[] rotateSub(int i, int j, int n) {
        int[] newCoordinates = new int[2];
        newCoordinates[0] = j;
        newCoordinates[1] = n - 1 - i;
        return newCoordinates;
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
