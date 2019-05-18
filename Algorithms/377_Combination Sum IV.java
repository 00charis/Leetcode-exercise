//注意，target == 0的时候结果全部定义成1

//v1: 不带备忘的DP.这个方法是会TLE的！不可以用
//最简单的递归就是写成自己调用自己的样子
public int combinationSum4(int[] nums, int target) {
    //注意，target == 0的时候结果定义为1
    if (target == 0) {
        return 1;
    }
    int res = 0;//但是初始化却是0
    for (int i = 0; i < nums.length; i++) {
        if (target >= nums[i]) {
            res += combinationSum4(nums, target - nums[i]);
        }
    }
    return res;
}

//v2: top down
//这个过程还是recursive的，但是是有备忘的
private int[] dp;

public int combinationSum4(int[] nums, int target) {
    dp = new int[target + 1];
    Arrays.fill(dp, -1);//记住这个函数
    dp[0] = 1;
    return helper(nums, target);
}

private int helper(int[] nums, int target) {
    if (dp[target] != -1) {
        return dp[target];
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
        if (target >= nums[i]) {
            res += helper(nums, target - nums[i]);
        }
    }
    dp[target] = res; //这一步是备忘的关键
    return res;
}

//v3: bottom up 
//bottom up的意思就是按顺序算，要用的值都已经算好了，不需要重复地计算
public int combinationSum4(int[] nums, int target) {
    int[] comb = new int[target + 1];
    //注意，comb[0]定义成1
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
}