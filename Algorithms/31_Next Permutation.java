//solution里面有个动画，看懂理解就好了
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        
        //find first decreasing element
        int i = nums.length - 2;
        for(; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                break;
            }
        }
        
        if(i >= 0){
            //find number just larger than nums[i]
            int j = nums.length - 1;
            while(j > i){
                if(nums[j] > nums[i]){
                    break;
                }
                j--;
            }
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1);
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int i){
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
        return;
    }
}