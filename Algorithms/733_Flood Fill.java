//这个题目要理解题意：意思是找四联通的区域把值全部都改变
//这里用的是dfs的解法
private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
		int m = image.length;
		int n = image[0].length;
		
		if(sr < 0 || sr >= m || sc < 0 || sc >=n || image[sr][sc] != oldColor) {
			return;
		}
		
		image[sr][sc] = newColor;
		dfs(image, sr - 1, sc, oldColor, newColor);
		dfs(image, sr + 1, sc, oldColor, newColor);
		dfs(image, sr, sc - 1, oldColor, newColor);
		dfs(image, sr, sc + 1, oldColor, newColor);
		
	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image[sr][sc] == newColor) {
			return image;
		}
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }