//用一个hashmap
//参考：https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77784
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k){
                ret  = Math.max(ret, i + 1);
            }
            else if(map.containsKey(sum - k)){
                ret  = Math.max(ret, i - map.get(sum - k));
            }
            
            //如果没有再放，因为如果更新会让距离变短
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            
        }
        return ret;
    }
}