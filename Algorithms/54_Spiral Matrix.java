//参考这里：https://leetcode.com/problems/spiral-matrix/discuss/
//非常符合想法，按照up, right, down, left的顺序遍历
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return ret;
        }
        
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while(up <= down && left <= right){
            //up
            for(int j = left; j <= right; j++){
                ret.add(matrix[up][j]);
            }
            up++;
            
            //right
            for(int i = up; i <= down; i++){
                ret.add(matrix[i][right]);
            }
            right--;
            
            //down
            if(up <= down){
                for(int j = right; j >= left; j--){
                    ret.add(matrix[down][j]);
                }
            }
            down--;
            
            //left
            if(left <= right){
                for(int i = down; i >= up; i--){
                    ret.add(matrix[i][left]);
                }
            }
            left++;
        }
        
        return ret;
    }
}