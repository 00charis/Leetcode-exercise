//用双指针做
class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int ret = 0;
        int lmax = 0;//初始化
        int rmax = 0;
        
        //最后停在最高的那个柱子
        while(i <= j){
            if(height[i] < height[j]){
                if(height[i] > lmax){
                    lmax = height[i];
                }
                else{
                    ret += lmax - height[i];
                }
                i++;
            }
            else{//height[i] >= height[j]
                if(height[j]  > rmax){
                    rmax = height[j];
                }
                else{
                    ret += rmax - height[j];
                }
                j--;
            }
        }
        return ret;
    }
}