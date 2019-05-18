//solution1: dp
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                //2种情况，不用coin[i - 1]和用coin[i - 1]
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j - coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}


//optimized
//Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]], then we can optimize the space by only using one-dimension array.
class Solution {
    public int change(int amount, int[] coins) {
        //int[][] dp = new int[coins.length+1][amount+1];
        int[] dp = new int[amount + 1];
        dp[0] = 1;
       
        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
}