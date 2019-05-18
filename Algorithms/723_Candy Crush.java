//这道题为了达到stable state 最重要的算法是递归。
//todo == true表明当前状态不是stable的，要再检测一轮。
class Solution {
    public int[][] candyCrush(int[][] board) {
        int R = board.length, C = board[0].length;
        boolean todo = false;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c + 2 < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c+1]) && v == Math.abs(board[r][c+2])) {
                    board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                    todo = true;
                }
            }
        }
        for (int r = 0; r + 2 < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r+1][c]) && v == Math.abs(board[r+2][c])) {
                    board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                    todo = true;
                }
            }
        }

        for (int c = 0; c < C; ++c) {
            int wr = R - 1;//新的记录指针从最下面开始
            for (int r = R-1; r >= 0; --r){
                //大于0的都是有效的值。
                if (board[r][c] > 0){
                    board[wr--][c] = board[r][c];
                }
            }
            while (wr >= 0)//把上面的用0填满
                board[wr--][c] = 0;
        }
        //写成一个递归的形式。这是最难的地方。自己调用自己。
        return todo ? candyCrush(board) : board;
    }
}