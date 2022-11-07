public class Matrix_Operations {

    public static void dividingMatrix(int[][] matrix, int[][] outputMatrix, int quadrant) {
        int n = matrix.length / 2;

        switch (quadrant) {
            case 1:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        outputMatrix[j][i] = matrix[j][i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        outputMatrix[j][i] = matrix[j + n][i];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        outputMatrix[j][i] = matrix[j][i + n];
                    }
                }
                break;
            case 4:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        outputMatrix[j][i] = matrix[j + n][i + n];
                    }
                }
                break;
        }
    }

    public static int[][] addition(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtraction(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
}

