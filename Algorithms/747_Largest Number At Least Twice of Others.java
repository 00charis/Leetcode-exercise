//做法：扫描2遍
class Solution {
    public int dominantIndex(int[] nums) {
    	//注意这里的初始化
		int max = nums[0];
		int ret = 0;
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] > max) {
				max = nums[i];
				ret = i;
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(i != ret && nums[i] * 2 > max) {
				return -1;
			}
		}
		
		return ret;
    }
}