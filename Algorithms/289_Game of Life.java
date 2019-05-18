//基本可以秒了
class Solution {
    //这个函数里面没有改变board的值。
    private int countNeigh(int[][] board, int i, int j){
        int ret = 0;
        int m = board.length;
        int n = board[0].length;
        
        int up = Math.max(0, i - 1);
        int down = Math.min(m - 1, i + 1);
        int left = Math.max(0, j - 1);
        int right = Math.min(n - 1, j + 1);
        
        for(int x = up; x <= down; x++){
            for(int y = left; y <= right; y++){
                ret += board[x][y] & 1;
            }
        }
        
        ret -= board[i][j] & 1;
        return ret;
    }
    
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        //这个循环改变了board右边第2位的值，但是右边第一位的值不会改变，也就是说还可以调用countNeigh
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                int cnt = countNeigh(board, i, j);
                if(board[i][j] == 1 && (cnt == 2 || cnt == 3)){
                    board[i][j] = 3;
                }
                
                if(board[i][j] == 0 && cnt == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                board[i][j] >>= 1;
            }
        }
        return;
    }
}