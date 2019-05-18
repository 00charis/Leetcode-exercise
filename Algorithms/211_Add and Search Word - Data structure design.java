class WordDictionary {
    class TrieNode{
        boolean isWord;
        TrieNode[] child;
        public TrieNode(){
            isWord = false;
            child = new TrieNode[26];
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()){
            if(p.child[c - 'a'] == null){
                p.child[c - 'a'] = new TrieNode();
            }
            p = p.child[c - 'a'];
        }
        p.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode p = root;
        return match(word, 0, p);
    }
    //这里是dfs。这个函数的意思是在当前节点的child节点里面匹配idx这个字符。p指向的匹配的是idx前面的字符
    public boolean match(String s, int idx, TrieNode p){
        if(p == null){
            return false;
        }
        if(s.length() == idx){
            return p.isWord;
        }
        
        if(s.charAt(idx) == '.'){
            for(int i = 0; i < 26; i++){
                if(match(s, idx + 1, p.child[i])){
                    return true;
                }
            }
            return false;
        }
        
        else{
            return match(s, idx + 1, p.child[s.charAt(idx) - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */