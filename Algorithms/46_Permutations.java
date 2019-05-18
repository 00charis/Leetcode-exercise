//v1: 最基础的backtracking的办法
//参考：https://leetcode.com/problems/permutations/discuss/18239
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        
        backtracking(nums, ret, new ArrayList<>());
        return ret;
    }
    
    public void backtracking(int[] nums, List<List<Integer>> ret, List<Integer> list){
        if(list.size() == nums.length){
            ret.add(new ArrayList<>(list));
        }
        //每次又都从0开始找
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            //外面这个list是不变的，每次往ret里面放要新建变量
            list.add(nums[i]);
            backtracking(nums, ret, list);
            list.remove(list.size()- 1);//remove(int index)这个函数要注意
        }
    }
}