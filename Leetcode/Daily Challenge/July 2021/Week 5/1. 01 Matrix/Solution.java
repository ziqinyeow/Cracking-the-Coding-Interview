public class Solution {

    public static void main(String[] args) {
        // int[][] matrix = {
        // {0, 0, 0},
        // {0, 1, 0},
        // {0, 0, 0}
        // };
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        matrix = updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int rowLast = matrix.length - 1;
        int colLast = matrix[0].length - 1;

        int[] row = matrix[0];
        int[] prevRow;
        if (row[0] == 1) {
            row[0] = rowLast + colLast + 2;
        }
        for (int c = 1; c <= colLast; c++) {
            if (row[c] == 1) {
                row[c] = row[c - 1] + 1;
            }
        }
        for (int r = 1; r <= rowLast; r++) {
            prevRow = row;
            row = matrix[r];
            if (row[0] == 1) {
                row[0] = prevRow[0] + 1;
            }
            for (int c = 1; c <= colLast; c++) {
                if (row[c] == 1) {
                    row[c] = Math.min(row[c - 1], prevRow[c]) + 1;
                }
            }
        }

        row = matrix[rowLast];
        for (int c = colLast - 1; c >= 0; c--) {
            if (row[c] > 1) {
                row[c] = Math.min(row[c], row[c + 1] + 1);
            }
        }
        for (int r = rowLast - 1; r >= 0; r--) {
            prevRow = row;
            row = matrix[r];
            if (row[colLast] > 1) {
                row[colLast] = Math.min(row[colLast], prevRow[colLast] + 1);
            }
            for (int c = colLast - 1; c >= 0; c--) {
                if (row[c] > 1) {
                    row[c] = Math.min(row[c], Math.min(row[c + 1], prevRow[c]) + 1);
                }
            }
        }
        return matrix;
    }
}