//输入：int[] nums = {1,3,3,3,5,7,8,13,20,21,29};
//v1: LC原题
//使用StringBuilder的append函数
class Solution {
    public List<String> summaryRanges1(int[] nums) {
        List<String> ret = new ArrayList<>();
	       if(nums == null || nums.length == 0) {
	    	   		return ret;
	       }
	       
	       int i = 0;
	       int j = 0;
	       while(i < nums.length) {
	    	   		j = i;
	    	   		while(j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
	    	   			j++;
	    	   		}
	    	   		StringBuilder sb = new StringBuilder();
	    	   		if(i == j) {
	    	   			sb.append(nums[i]);
	    	   		}
	    	   		else {
	    	   			sb.append(nums[i]).append("->").append(nums[j]);
	    	   		}
	    	   		ret.add(sb.toString());
	    	   		i = j + 1;
	       }
	       return ret; 
    }
}

//v2:
//有重复的值，重复的值只保留一个： [1, 3, 5, 7->8, 13, 20->21, 29]
public List<String> summaryRangesRemoveDuplicate(int[] nums) {
	   List<String> ret = new ArrayList<>();
       if(nums == null || nums.length == 0) {
    	   		return ret;
       }
       
       int i = 0;
       int j = 0;
       while(i < nums.length) {
    	   	 j = i;
    	   	 while(j + 1< nums.length && nums[j + 1] <= nums[j] + 1) {
    	   		 j++;
    	   	 }
    	   	 StringBuilder sb = new StringBuilder();
    	   	 if(nums[j] == nums[i]) {
    	   		 sb.append(nums[i]);
    	   	 }
    	   	 else {
    	   		 sb.append(nums[i]).append("->").append(nums[j]);
    	   	 }
    	   	 ret.add(sb.toString());
    	   	 i = j + 1;
       }
       return ret;
}


//v3:
//有重复的值，保留多个相同的值： [1, 3, 3, 3, 5, 7->8, 13, 20->21, 29]
public List<String> summaryRangesKeepDuplicate(int[] nums) {
	List<String> ret = new ArrayList<>();
    if(nums == null || nums.length == 0) {
 	   		return ret;
    }
    
    int i = 0;
    int j = 0;
    while(i < nums.length) {
 	   	 j = i;
 	   	 while(j + 1< nums.length && nums[j + 1] <= nums[j] + 1) {
 	   		 if(nums[j + 1] == nums[j]) {
 	   			 break;
 	   		 }
 	   		 j++;
 	   	 }
 	   	 StringBuilder sb = new StringBuilder();
 	   	 if(nums[j] == nums[i]) {
 	   		 sb.append(nums[i]);
 	   	 }
 	   	 else {
 	   		 sb.append(nums[i]).append("->").append(nums[j]);
 	   	 }
 	   	 ret.add(sb.toString());
 	   	 i = j + 1;
    }
    return ret;
}

//v4:
//没有重复的值，计算gap
//输入：[1,3,5,7,8,13,20,21,29]
//输出：[1->7/2, 8->13/5, 20->21/1, 29]
public List<String> summaryRangesGap(int[] nums) {
	 List<String> ret = new ArrayList<>();
	 if(nums == null || nums.length == 0) {
		 return ret;
	 }
	 
	 int i = 0;
	 int j = 0;
	 int gap = 0;
	 while(i < nums.length) {
		 if(j == i && j + 1 < nums.length) {
			 gap = nums[j + 1] - nums[j];
			 j++;
		 }
		 while(j + 1 < nums.length && gap == nums[j + 1] - nums[j]) {
			 j++;
		 }
		 StringBuilder sb = new StringBuilder();
		 if(gap == 0) {
			 sb.append(nums[i]);
		 }
		 else {
			 sb.append(nums[i]).append("->").append(nums[j]).append("/").append(gap);
		 }
		 ret.add(sb.toString());
		 i = j + 1;
		 j = i;
		 gap = 0;
	 }
     return ret;
 }

