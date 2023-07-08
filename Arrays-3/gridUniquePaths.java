class gridUniquePaths{

    public int bruteforce(int m,int n){
        if( m == 1 || n == 1) return 1;
        return bruteforce(m-1,n)+bruteforce(m,n-1);
    }

    public int better(int m,int n){
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            grid[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            grid[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }

    public int optimal(int m,int n){  
        return 0;
    }

    public int calculateUniquePaths(int m,int n){
        int ans = 0;
        // ans = bruteforce(m,n);
        // ans = better(m,n);
        ans = optimal(m, n);
        return ans;
    }

    public static void main(String[] args) {
        gridUniquePaths gup = new gridUniquePaths();
        int m = 4, n = 5;
        int ans = gup.calculateUniquePaths(m,n);
        System.out.println(ans);
    }
}