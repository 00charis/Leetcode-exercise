//参考solution
//注意，题目里面有很重要的限制条件：Tasks could be done without original order.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        
        for(char c : tasks){
            map[c - 'A']++;
        }
        
        Arrays.sort(map);
        
        int maxVal = map[25];
        int slots = (maxVal - 1) * n;
        
        for(int i = 24; i >= 0; i--){
            slots -= Math.min(maxVal - 1, map[i]);
        }
        
        return slots > 0 ? slots + tasks.length : tasks.length;
    }
}