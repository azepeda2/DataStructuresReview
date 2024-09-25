import java.util.ArrayDeque;
import java.util.Arrays;

public class ClickEmptySquareMineSweeper {
    public static int[][] click(int[][] field, int rows, int cols, int inputI, int inputJ) {
        ArrayDeque<int[]> toCheck = new ArrayDeque<int[]>();

        if (field[inputI][inputJ] == 0) {
            field[inputI][inputJ] = -2;
            int[] coordinates = { inputI, inputJ };
            toCheck.add(coordinates);

        } else {
            return field;
        }

        while (!toCheck.isEmpty()) {
            int[] currentCoordinates = toCheck.remove();

            for (int i = currentCoordinates[0] - 1; i < currentCoordinates[0] + 2; ++i) {
                for (int j = currentCoordinates[1] - 1; j < currentCoordinates[1] + 2; ++j) {
                    if (0 <= i && i < rows &&
                            0 <= j && j < cols &&
                            field[i][j] == 0) {
                        field[i][j] = -2;
                        int[] coordinates = { i, j };
                        toCheck.add(coordinates);
                    }
                }
            }
        }

        return field;
    }

    public static void printField(int[][] field) {
        for (int[] row : field) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] field1 = { { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0 },
                { 0, 1, -1, 1, 0 } };

        // click(field1, 3, 5, 2, 2) should return:
        // [[0, 0, 0, 0, 0],
        // [0, 1, 1, 1, 0],
        // [0, 1, -1, 1, 0]]

        // click(field1, 3, 5, 1, 4) should return:
        // [[-2, -2, -2, -2, -2],
        // [-2, 1, 1, 1, -2],
        // [-2, 1, -1, 1, -2]]

        int[][] field2 = { { -1, 1, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 },
                { 0, 0, 1, -1 } };

        // click(field2, 4, 4, 0, 1) should return:
        // [[-1, 1, 0, 0],
        // [1, 1, 0, 0],
        // [0, 0, 1, 1],
        // [0, 0, 1, -1]]

        // click(field2, 4, 4, 1, 3) should return:
        // [[-1, 1, -2, -2],
        // [1, 1, -2, -2],
        // [-2, -2, 1, 1],
        // [-2, -2, 1, -1]]

        System.out.println("Before Field1: \n");
        printField(field1);

        field1 = click(field1, 3, 5, 2, 2);

        System.out.println("Field1: \n");
        printField(field1);

        field1 = click(field1, 3, 5, 1, 4);

        System.out.println("Field1: \n");
        printField(field1);

        System.out.println("Before Field2: \n");
        printField(field2);

        field2 = click(field2, 4, 4, 0, 1);

        System.out.println("Field2: \n");
        printField(field2);

        field2 = click(field2, 4, 4, 1, 3);

        System.out.println("Field2: \n");
        printField(field2);

    }
}
