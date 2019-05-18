//backtracking的题，注意，同一个索引的元素不可以重复用
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        
        backtracking(candidates, target, list, ret, 0);
        
        return ret;
    }
    
    private void backtracking(int[] candidates, int remain, List<Integer> list, List<List<Integer>> ret, int start){
        if(remain == 0){
            ret.add(new ArrayList<>(list));
        }
        
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > remain){
                break;
            }
            
            if(i == start || candidates[i] != candidates[i - 1]){//这里要去重复
                //因为candidates已经是排序的，所以肯定可以保证结果是有序的
                list.add(candidates[i]);
                backtracking(candidates, remain - candidates[i], list, ret, i + 1);
                list.remove(list.size() - 1);
            }
        }
        return;
    }
}