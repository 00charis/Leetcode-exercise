//backtracking的方法
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        backtracking(list, ret, k, n, 1);
        
        return ret;
    }
    
    private void backtracking(List<Integer> list, List<List<Integer>> ret, int k, int remain, int start){
        if(list.size() == k && remain == 0){
            ret.add(new ArrayList<>(list));
            return;
        } 
        
        if(list.size() == k || remain == 0){
            return;
        }
        
        for(int i = start; i <= 9 && i <= remain; i++){
            //因为candidates已经排序了所以肯定可以保证得到的list的是有序的
            list.add(i);
            backtracking(list, ret, k, remain - i, i + 1);
            list.remove(list.size() - 1);
        }
        return;
    }
}