public class Naive_Divide_and_Conquer {

    public static int[][] divideAndConquer(int[][] matrixA, int[][] matrixB, int n){
        int[][] matrixC = new int[n][n];

        if(n == 1){
            matrixC[0][0] = matrixA[0][0] * matrixB[0][0];
        } else {
            int[][] a11 = new int[n / 2][n / 2];
            int[][] a12 = new int[n / 2][n / 2];
            int[][] a21 = new int[n / 2][n / 2];
            int[][] a22 = new int[n / 2][n / 2];
            int[][] b11 = new int[n / 2][n / 2];
            int[][] b12 = new int[n / 2][n / 2];
            int[][] b21 = new int[n / 2][n / 2];
            int[][] b22 = new int[n / 2][n / 2];
            int[][] c11;
            int[][] c12;
            int[][] c21;
            int[][] c22;

            // partition the matrices into quadrants
            Matrix_Operations.dividingMatrix(matrixA, a11, 1);
            Matrix_Operations.dividingMatrix(matrixA, a12, 2);
            Matrix_Operations.dividingMatrix(matrixA, a21, 3);
            Matrix_Operations.dividingMatrix(matrixA, a22, 4);
            Matrix_Operations.dividingMatrix(matrixB, b11, 1);
            Matrix_Operations.dividingMatrix(matrixB, b12, 2);
            Matrix_Operations.dividingMatrix(matrixB, b21, 3);
            Matrix_Operations.dividingMatrix(matrixB, b22, 4);

            c11 = Matrix_Operations.addition(divideAndConquer(a11, b11, a11.length), divideAndConquer(a12, b21, a12.length));
            c12 = Matrix_Operations.addition(divideAndConquer(a11, b12, a11.length), divideAndConquer(a12, b22, a12.length));
            c21 = Matrix_Operations.addition(divideAndConquer(a21, b11, a21.length), divideAndConquer(a22, b21, a22.length));
            c22 = Matrix_Operations.addition(divideAndConquer(a21, b12, a21.length), divideAndConquer(a22, b22, a22.length));

            // join matrixC together from c quadrants
            for (int i = 0; i < c11.length; i++) {
                for (int j = 0; j < c11.length; j++) {
                    matrixC[i][j] = c11[i][j];
                    matrixC[i + n / 2][j] = c12[i][j];
                    matrixC[i][j + n / 2] = c21[i][j];
                    matrixC[i + n / 2][j + n / 2] = c22[i][j];
                }
            }
        }return matrixC;
    }
}


