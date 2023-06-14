import java.util.*;

public class rotateMatrix {

    public void rotateInplace(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotateUsingSpace(int[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        int[][] matrixDup = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=col-1;j>=0;j--){
                matrixDup[i][(col-1)-j] = matrix[j][i];
            }
        }
        System.out.println(Arrays.deepToString(matrixDup));
    }

    public void rotate(int[][] matrix){
        // rotateUsingSpace(matrix);
        rotateInplace(matrix);
    }

    public static void main(String[] args) {
        rotateMatrix rm = new rotateMatrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rm.rotate(matrix);
    }
}