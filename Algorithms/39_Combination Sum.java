//v1: dp
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>();
        List<Integer> nullList = new ArrayList<>();
        List<List<Integer>> nullSet = new ArrayList<>();
        
        dp.add(nullSet);
        for(int t = 1; t <= target; t++){
            //每个递归的层是一个二维的list
            List<List<Integer>> newSet = new ArrayList<>();
            for(int i = 0; i < candidates.length && candidates[i] <= t; i++){//for循环就加入一个判断条件
                if(candidates[i] == t){
                    //这个函数学会用
                    newSet.add(Arrays.asList(candidates[i]));
                }
                else{
                    for(List<Integer> l : dp.get(t - candidates[i])){
                        if(candidates[i] >= l.get(l.size() - 1)){//保持有序，这也是去重复的方法
                            List<Integer> newList = new ArrayList<>();
                            newList.addAll(l);
                            newList.add(candidates[i]);
                            newSet.add(newList);
                        }
                    }
                }
            }
            dp.add(newSet);
        }
        return dp.get(target);
    }
}


//v2: backtracking
class Solution {
    private List<List<Integer>> ret = new ArrayList<>();
    
    private void backtrack(List<Integer> curr, int[] candidates, int remain, int idx){
        if(remain == 0){
            //注意，这里必须要进行new ArrayList<>，因为要加入新的对象
            ret.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = idx; i < candidates.length; i++){//每个list都是递增的，不要求严格
            if(remain - candidates[i] < 0){
                break;//减少递归层数
            }
            curr.add(candidates[i]);
            backtrack(curr, candidates, remain - candidates[i], i);//可以使用重复的值
            curr.remove(curr.size() - 1);
        }
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//减少递归层数，同样也是为了去除重复的情况
        backtrack(new ArrayList<>(), candidates, target, 0);
        return ret;
    }
}