//非常简单的题目，就是遍历矩阵的元素
class Solution {
    public int[][] imageSmoother(int[][] M) {
		int row = M.length;
		int col = M[0].length;
		int[][] ret = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int count = 0;
				int sum = 0;
				int up = Math.max(0, i - 1);
				int down = Math.min(i + 1, row - 1);
				int left = Math.max(0, j - 1);
				int right = Math.min(j + 1, col - 1);
				
				for(int x = up; x <= down; x++) {
					for(int y = left; y <= right; y++) {
						count++;
						sum += M[x][y];
					}
				}
				
				ret[i][j] = sum / count;
				
			}
		}
		return ret;
    }
}