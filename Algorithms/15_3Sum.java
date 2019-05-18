//代码结构非常简单，细节去重复注意一下
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){//去重
                continue;
            }
            
            int a = nums[i];
            int target = -a;
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k){
                int b = nums[j];
                int c = nums[k];
                int sum = b + c;
                if(sum == target){
                    ret.add(Arrays.asList(a, b, c));//学习这个语法
                    while(j < k && nums[j] == nums[j + 1]){//去重
                        j++;
                    }
                    while(j < k && nums[k] == nums[k - 1]){//去重
                        k--;
                    }
                    j++;
                    k--;
                }
                else if (sum < target ){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ret;
    }
}