class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) {
        		return false;
        }
        
        int len = words1.length;
        
        Set<String> set =  new HashSet<>();
        for(int i = 0; i < pairs.length; i++) {
        		set.add(new String(pairs[i][0] + "#" + pairs[i][1]));
        }
        
        for(int i = 0; i < len; i++) {
                //注意看题目的限制条件，是pair，所以只有下面的3种情况
        		if( (words1[i]).equals(words2[i]) || set.contains(words1[i] + "#" + words2[i]) ||
        				set.contains(words2[i] + "#" + words1[i])) {
        			
        		}
        		else {
        			return false;
        		}
        }
        return true;
    }
}