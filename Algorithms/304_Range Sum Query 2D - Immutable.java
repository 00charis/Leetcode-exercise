//参考：https://leetcode.com/problems/range-sum-query-2d-immutable/solution/
//看懂计算的数学原理就可以了
//细节注意
class NumMatrix {
    private int[][] dp;
    
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
            }
        }
    }
    
    //看这里，2相关的要加一，1相关的不加一
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */