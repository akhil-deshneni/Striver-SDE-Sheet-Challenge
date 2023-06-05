import java.util.*;

class Pair{
    int key;
    int value;
    Pair(int key,int value){
        this.key = key;
        this.value = value;
    }
}

class Bruteforce {
    // TC: O(MN*(M+N)) Space: O(MN)
    public void setrowcoltozero(int[][] matrix,int r,int c){
        // setting row values to zeros
        for(int i=0;i<matrix[0].length;i++){
            matrix[r][i] = 0;
        }
        // setting col values to zeros
        for(int i=0;i<matrix.length;i++){
            matrix[i][c] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        // queue for storing the cells(a postion in matrix) which is set to zero
        Queue<Pair> zeros = new LinkedList<>();
        // This is to iterate over the matrix 
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    zeros.add(new Pair(i,j));
                }
            }
        }
        // processing all the cells one by one and setting coressponding row and col to zero
        while(!zeros.isEmpty()){
            Pair zero = zeros.poll();
            setrowcoltozero(matrix,zero.key,zero.value);
        }
    }
}

class Optimal {
    public void setZeroes(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check if the first row and first column need to be set to zero
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Iterate over the matrix and use the first row and first column as markers
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set rows and columns (excluding the first row and first column) to zero
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set the first row and first column to zero if necessary
        if (firstRowHasZero) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}


public class SetMatrixZeros{
    public static void main(String[] args) {
        // Bruteforce bf = new Bruteforce();
        Optimal os = new Optimal();
        int matrix[][] = {
            {0,1,2,0},{3,4,5,2},{1,3,1,5}
        };
        // bf.setZeroes(matrix);
        os.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}