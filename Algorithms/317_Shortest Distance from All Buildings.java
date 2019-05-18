//bfs的题，参考：https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76891
//不难，循环有点多
class Solution {
    private int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};    

    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int numBuilding = 0;
        //for empty pos。这2个变量的定义很重要
        int[][] distance = new int[m][n];
        int[][] count = new int[m][n];
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    numBuilding++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    int level = 1;
                    //这样可以剪枝
                    boolean[][] visited = new boolean[m][n]; //false
                    
                    
                    while(!q.isEmpty()){//bfs遍历的时候记录距离
                        int qsize = q.size();
                        for(int s = 0; s < qsize; s++){
                            int[] curr = q.poll();
                        
                            for(int t = 0; t < 4; t++){
                                int x = curr[0] + d[t][0];
                                int y = curr[1] + d[t][1];

                                if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 0 && visited[x][y] == false){
                                    visited[x][y] = true;
                                    distance[x][y] += level;
                                    count[x][y]++;
                                    q.offer(new int[]{x, y});
                                }
                            }
                        }
                        level++; 
                    } 
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && count[i][j] == numBuilding){
                    ret = Math.min(ret, distance[i][j]);
                }
            }
        }
        
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}