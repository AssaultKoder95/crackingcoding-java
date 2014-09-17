package arrays_strings;

public class SetMatrixZeroes {

    public static int[][] setRowColumnToZero(int[][] matrix) {
        int[] rows = new int[matrix.length], cols = new int[matrix[0].length];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = cols[j] = 1;
                }
            }
        }
        for(int i = 0 ; i < rows.length; i++){
            for(int j = 0; j <cols.length; j++) {
                if(rows[i] == 1 || cols[j] == 1)
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] { { 1, 0, 4, 6 }, { 4, 5, 9, 8}, { 7, 8, 4, 3 } };
        SetMatrixZeroes.setRowColumnToZero(test);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
