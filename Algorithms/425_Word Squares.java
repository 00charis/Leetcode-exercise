//参考这里：https://leetcode.com/problems/word-squares/discuss/91333
//backtracking的题
class Solution {
    //前面是2个辅助的类
    class TrieNode{
        List<String> startWith;
        TrieNode[] child;
        public TrieNode(){
            startWith = new ArrayList<>();
            child = new TrieNode[26];
        }
    }
    
    class Trie{
        TrieNode root;
        public Trie(String[] words){
            root = new TrieNode();
            for(String word : words){
                TrieNode p = root;
                p.startWith.add(word);

                for(char c : word.toCharArray()){
                    if(p.child[c - 'a'] == null){
                        p.child[c - 'a'] = new TrieNode();
                    }
                    p.child[c - 'a'].startWith.add(word);
                    p = p.child[c - 'a'];
                }
            }
        }
        
        //以“”为prefix的是所有的word，这个在backtracking的时候用的到
        public List<String> findPrefix(String prefix){
            TrieNode p = root;
            
            for(char c : prefix.toCharArray()){
                if(p.child[c - 'a'] == null){
                    return new ArrayList<>();
                }
                p = p.child[c - 'a'];
            }
            return p.startWith;
        }
    }
    
    //这里开始是程序的主体
    private Trie tr;
    private int len;
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<>();
        if(words == null || words.length == 0){
            return ret;
        }
        len = words[0].length();
        tr = new Trie(words);
        
        List<String> list = new ArrayList<>();
        backtracking(tr, ret, list);  
        return ret;
    }
    
    private void backtracking(Trie tr, List<List<String>> ret, List<String> list){
        int idx = list.size();
        if(idx == len){
            //因为list有add和remove，所以要new
            ret.add(new ArrayList<>(list));
            return;
        }
        String prefix = "";
        for(int i = 0; i < list.size(); i++){
            prefix += list.get(i).charAt(idx);
        }
        
        List<String> prefixWords = tr.findPrefix(prefix);
        
        for(String prefixWord : prefixWords){
            list.add(prefixWord);
            backtracking(tr, ret, list);
            list.remove(list.size() - 1);
        }
        return;
    }
}