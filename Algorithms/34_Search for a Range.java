//二分查找，自己已经做的很熟练了
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //必须要判断这个条件
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        
        int left = -1;
        int right = -1;
        
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                left = mid;
                r = mid;
            }
            else if(nums[mid] > target){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        if(nums[l] == target){
            left = l;
        }
        else if(nums[r] == target){
            left = r;
        }
        
        //
        l = 0;
        r = nums.length - 1;
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                right = mid;
                l = mid;
            }
            else if(nums[mid] > target){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        if(nums[r] == target){
            right = r;
        }
        else if(nums[l] == target){
            right = l;
        }
        //注意这里的语法，必须是new int[]{-1, -1}
        return left == -1 ? new int[]{-1, -1} : new int[]{left, right};
    }
}