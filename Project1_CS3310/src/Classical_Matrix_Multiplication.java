import java.util.*;

/**
 * Take the two matrices as input to be multiplies
 * Two matrices with size n x n is being passed in the parameter.
 * The function returns matrix resultant Matrix C
 */
public class Classical_Matrix_Multiplication {
    public static int[][] matrixMultiply(int[][] matrixA, int[][] matrixB, int n) {

        int matrixC[][] = new int[n][n];
        int i, j, k;


        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++)
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
            }
        }

        return matrixC;
    }
}
