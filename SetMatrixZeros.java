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

class Optimal{

    // TC: O(MN) SP: O(1)
    public void setRowToZero(int[][] matrix,int row){
        for(int i=1;i<matrix[0].length;i++){
            matrix[row][i] = 0;
        }
    }

    public void setColToZero(int[][] matrix,int col){
        for(int i=1;i<matrix.length;i++){
            matrix[i][col] = 0;
        }
    }

    public void handleEdgeCase(int[][] matrix,boolean[] verifier){
        if(verifier[0] && verifier[1] || verifier[2]){
            setRowToZero(matrix,0);
            setColToZero(matrix,0);
        }
        else if(verifier[0]){
            setRowToZero(matrix,0);
        }
        else if(verifier[1]){
            setColToZero(matrix,0);
        }
    }

    public void setZeroes(int[][] matrix) {
        //setting up matrix row and col to zero as a marker to make the corresponding row and col to zero
        int col = matrix[0].length, row = matrix.length;
        boolean[] verifier = new boolean[3];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0){
                    System.out.println(i+"->"+j);
                    verifier[0] = (i == 0 || verifier[0]) ? true : false;
                    verifier[1] = (j == 0 || verifier[1]) ? true : false;
                    verifier[2] = ((i == 0 && j == 0) || verifier[2]) ? true: false;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // System.out.println(Arrays.toString(verifier));
        for(int i=1;i<col;i++){
            if(matrix[0][i] == 0){
                setColToZero(matrix,i);
            }
        } 
        for(int i=1;i<row;i++){
            if(matrix[i][0] == 0){
                setRowToZero(matrix,i);
            }
        }
        handleEdgeCase(matrix,verifier);
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