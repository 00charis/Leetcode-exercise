//遍历所有的element，
//将每一个element和top left neighbour 比较
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; i++) {
        		for(int j = 0; j < n; j++) {
        			if(i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
        				return false;
        			}
        		}
        }
        return true;
    }
	
}