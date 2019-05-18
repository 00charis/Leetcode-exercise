//是一个比较trick的题，
//参考这个理解：https://leetcode.com/problems/max-consecutive-ones-ii/discuss/
//Here q stores the index of zero within the window [l, h]
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int q = -1;
        int ret = 0;
        for(int l = 0, h = 0; h < nums.length; h++){
            if(nums[h] == 0){
                l = q + 1;
                q = h;
            }
            ret = Math.max(ret, h - l + 1);
        }
        return ret;
    }
}