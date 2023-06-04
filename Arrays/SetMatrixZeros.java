import java.util.*;
import javafx.util.Pair;

class Bruteforce {
    // TC: O(M*N*(M+N)) Space: O(1)
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
        Queue<Pair<Integer,Integer>> zeros = new LinkedList<>();
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
            Pair<Integer,Integer> zero = zeros.poll();
            setrowcoltozero(matrix,zero.getKey(),zero.getValue());
        }
    }
}

public class SetMatrixZeros{
    public static void main(String[] args) {
        Bruteforce bf = new Bruteforce();
        int matrix[][] = {
            {1,1,1},{1,0,1},{1,1,1}
        };
        bf.setZeroes(matrix);
    }
}