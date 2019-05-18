//dfs解法，这个题目做了很多遍了。
class Solution {
    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        return;
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    ret++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return ret;
    }
}