public class search2DMatrix {

    // This method scans each cell in the matrix and compares every value to target.
    // TC: O(M*N) Space: O(1)
    private boolean Approach1(int[][] matrix,int target){
        int row = matrix.length, col = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    private boolean searchRow(int[][] matrix,int row,int target){
        int arr[] = matrix[row];
        int lo = 0, hi = arr.length-1;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] < target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return false;
    }

    private boolean Approach2(int[][] matrix,int target){
        int row = matrix.length, col = matrix[0].length;
        for(int i=0;i<row;i++){
            if(target <= matrix[i][col-1]){
                return searchRow(matrix,i,target);
            }
        }
        return false;
    }

    private boolean searchMatrix(int[][] matrix,int target){
        boolean ans = false;
        // ans = Approach1(matrix,target);
        ans = Approach2(matrix,target);
        return ans;
    }

    public static void main(String[] args) {
        search2DMatrix s2m = new search2DMatrix();
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target = 61;
        boolean flag = s2m.searchMatrix(matrix,target);
        if(flag){
            System.out.println("Target is present in the matrix");
        }else{
            System.out.println("Target is not present in the matrix");
        }
    }
}
