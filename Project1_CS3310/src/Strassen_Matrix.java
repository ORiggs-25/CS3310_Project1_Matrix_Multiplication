public class Strassen_Matrix {

    public static int[][] strassen_multiplication(int[][] matrixA, int[][] matrixB, int[][] matrixC, int n) {

        int[][] c11;
        int[][] c12;
        int[][] c21;
        int[][] c22;

        if (n == 2) {
            matrixC[0][0] = (matrixA[0][0] * matrixB[0][0]) + (matrixA[1][0] * matrixB[0][1]);
            matrixC[1][0] = (matrixA[0][0] * matrixB[1][0]) + (matrixA[1][0] * matrixB[1][1]);
            matrixC[0][1] = (matrixA[0][1] * matrixB[0][0]) + (matrixA[1][1] * matrixB[0][1]);
            matrixC[1][1] = (matrixA[0][1] * matrixB[1][0]) + (matrixA[1][1] * matrixB[1][1]);
        } else {
            n /= 2;
            int[][] a11 = new int[n][n];
            int[][] a12 = new int[n][n];
            int[][] a21 = new int[n][n];
            int[][] a22 = new int[n][n];
            int[][] b11 = new int[n][n];
            int[][] b12 = new int[n][n];
            int[][] b21 = new int[n][n];
            int[][] b22 = new int[n][n];
            int[][] p = new int[n][n];
            int[][] q = new int[n][n];
            int[][] r = new int[n][n];
            int[][] s = new int[n][n];
            int[][] t = new int[n][n];
            int[][] u = new int[n][n];
            int[][] v = new int[n][n];
            n *= 2;

            // dividing the matrices into quadrants
            Matrix_Operations.dividingMatrix(matrixA, a11, 1);
            Matrix_Operations.dividingMatrix(matrixA, a12, 2);
            Matrix_Operations.dividingMatrix(matrixA, a21, 3);
            Matrix_Operations.dividingMatrix(matrixA, a22, 4);
            Matrix_Operations.dividingMatrix(matrixB, b11, 1);
            Matrix_Operations.dividingMatrix(matrixB, b12, 2);
            Matrix_Operations.dividingMatrix(matrixB, b21, 3);
            Matrix_Operations.dividingMatrix(matrixB, b22, 4);

            strassen_multiplication(Matrix_Operations.addition(a11, a22), Matrix_Operations.addition(b11, b22), p, n / 2);
            strassen_multiplication(Matrix_Operations.addition(a21, a22), b11, q, n / 2);
            strassen_multiplication(a11, Matrix_Operations.subtraction(b12, b22), r, n / 2);
            strassen_multiplication(a22, Matrix_Operations.subtraction(b21, b11), s, n / 2);
            strassen_multiplication(Matrix_Operations.addition(a11, a12), b22, t, n / 2);
            strassen_multiplication(Matrix_Operations.subtraction(a21, a11), Matrix_Operations.addition(b11, b12), u, n / 2);
            strassen_multiplication(Matrix_Operations.subtraction(a12, a22), Matrix_Operations.addition(b21, b22), v, n / 2);

            c11 = Matrix_Operations.addition(Matrix_Operations.subtraction(Matrix_Operations.addition(p, s), t), v);
            c12 = Matrix_Operations.addition(r, t);
            c21 = Matrix_Operations.addition(q, s);
            c22 = Matrix_Operations.addition(Matrix_Operations.subtraction(Matrix_Operations.addition(p, r), q), u);

            // put result matrix together from c quadrants
            for (int i = 0; i < c11.length; i++) {
                for (int j = 0; j < c11.length; j++) {
                    matrixC[i][j] = c11[i][j];
                    matrixC[i + n / 2][j] = c12[i][j];
                    matrixC[i][j + n / 2] = c21[i][j];
                    matrixC[i + n / 2][j + n / 2] = c22[i][j];
                }
            }
        }
        return matrixC;
    }
}
