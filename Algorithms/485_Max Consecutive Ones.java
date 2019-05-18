//题目很简单，可以参考这个答案，便于理解
//https://leetcode.com/problems/max-consecutive-ones/discuss/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        int currmax = 0;//到当前index为止的consecutive 0s
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                currmax++;
                ret = Math.max(ret, currmax);
            }
            else{
                currmax = 0;
            }
            
        }
        return ret;
    }
}