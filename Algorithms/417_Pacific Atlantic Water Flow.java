//参考：https://discuss.leetcode.com/topic/62379/java-bfs-dfs-from-ocean
//这是一个bfs的做法
class Solution {
    private int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
   
    
    //传进来的矩阵是传值的，会改变矩阵的值。
    private void bfs(int[][] matrix, Queue<int[]> q, boolean[][] visited){
        int m = matrix.length;
        int n = matrix[0].length;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int i = 0; i < 4; i++){
                int x = curr[0] + d[i][0];
                int y = curr[1] + d[i][1];

                //这里要判断是否visited
                if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < matrix[curr[0]][curr[1]]){
                    continue;
                }
                
                q.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return;
    }
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new LinkedList<>();
        if(matrix == null || matrix.length == 0){
            return ret;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        //2个visited矩阵
        boolean[][] pa = new boolean[m][n];
        boolean[][] at = new boolean[m][n];
        
        //2个queue
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        
        for(int j = 0; j < n; j++){
            pq.offer(new int[]{0, j});
            aq.offer(new int[]{m - 1, j});
            pa[0][j] = true;
            at[m - 1][j] = true;
        }
        
        for(int i = 0; i < m; i++){
            pq.offer(new int[]{i, 0});
            aq.offer(new int[]{i, n - 1});
            pa[i][0] = true;
            at[i][n - 1] = true;
        }
        
        bfs(matrix, pq, pa);
        bfs(matrix, aq, at);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pa[i][j] == true && at[i][j] == true){
                    ret.add(new int[]{i, j});
                }
            }
        }
        return ret;
    }
}