//非常简单，秒了
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int ret = 0;
        
        for(int i = 1; i < n; i++){
            if(knows(ret, i)){
                ret = i;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i == ret){
                continue;
            }
            
            if(knows(ret, i) || !knows(i, ret)){
                return -1;
            }
        }
        return ret;
    }
}