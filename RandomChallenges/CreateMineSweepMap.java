import java.util.Arrays;

public class CreateMineSweepMap {
    public static int[][] mineSweeper(int[][] bombs, int rows, int cols) {
        int[][] field = new int[rows][cols];

        for (int[] bomb : bombs) {
            int bombRow = bomb[0];
            int bombCol = bomb[1];
            field[bombRow][bombCol] = -1;

            for (int i = bombRow - 1; i < bombRow + 2; ++i) {
                for (int j = bombCol - 1; j < bombCol + 2; ++j) {
                    if (0 <= i && i < rows &&
                            0 <= j && j < cols &&
                            field[i][j] != -1) {
                        ++field[i][j];
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
        int[][] bombs1 = { { 0, 2 }, { 2, 0 } };
        // mineSweeper(bombs1, 3, 3) should return:
        // [[0, 1, -1],
        // [1, 2, 1],
        // [-1, 1, 0]]

        int[][] bombs2 = { { 0, 0 }, { 0, 1 }, { 1, 2 } };
        // mineSweeper(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        // [2, 3, -1, 1],
        // [0, 1, 1, 1]]

        int[][] bombs3 = { { 1, 1 }, { 1, 2 }, { 2, 2 }, { 4, 3 } };
        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        // [1, -1, -1, 2, 0],
        // [1, 3, -1, 2, 0],
        // [0, 1, 2, 2, 1],
        // [0, 0, 1, -1, 1]]

        int[][] field1 = mineSweeper(bombs1, 3, 3);
        int[][] field2 = mineSweeper(bombs2, 3, 4);
        int[][] field3 = mineSweeper(bombs3, 5, 5);

        System.out.println("Field1: \n");
        printField(field1);
        System.out.println("Field2: \n");
        printField(field2);
        System.out.println("Field3: \n");
        printField(field3);
    }
}
