//backtracking
//参考这里：https://leetcode.com/problems/subsets/discuss/27281
class Solution {
    private void backtracking(int[] nums, List<List<Integer>> ret, List<Integer> curr, int start){
        ret.add(new ArrayList<>(curr));//这里必须要重新实例化一个ArrayList，否则在往ret里面重复地添加List
        //这个为什么非常重要！！
        
        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            backtracking(nums, ret, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        backtracking(nums, ret, curr, 0);
        
        return ret;
    }
}