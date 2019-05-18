//参考solution3
//题目2个要求：
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
class Solution {
    public void moveZeroes(int[] nums) {
        int lastNoZero = 0;
        
        //从lastNoZero到j之间都是0，区间开闭自己举例子。大概这么理解
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
               int temp = nums[i];
               nums[i] = nums[lastNoZero];
               nums[lastNoZero] = temp;
               lastNoZero++;
            }
        }
        
        return;
    }
}