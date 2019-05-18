//v1: 最基础的backtracking的办法
//参考：https://leetcode.com/problems/permutations/discuss/18239
//参考答案是一个backtracking的general的方法的合集。
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        //学习这个函数，int[]数组是这样排序的
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, ret, new ArrayList<>());
        return ret;
    }
    
    public void backtracking(int[] nums, boolean used[], List<List<Integer>> ret, List<Integer> list){
        if(list.size() == nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            //这个条件判断很重要
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, ret, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}