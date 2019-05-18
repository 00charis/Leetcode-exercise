import java.util.List;

class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root: roots) {
            //每一个word都插入到Trie中
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            //直接把word写到Trie Node中
            cur.word = root;
        }

        //当要用append的时候，一般会用StringBuilder
        StringBuilder ans = new StringBuilder();
        //How do I split a string with any whitespace chars as delimiters?
        String[] words = sentence.split("\\s+");
        for (String word: words) {
            if (ans.length() > 0){
                ans.append(" ");
            }

            TrieNode cur = trie;
            char[] wordArray = word.toCharArray();
            for (char letter: wordArray) {
                    //if结果是有了确定的结果：1)确认没有；2)找到了，这里，题目让匹配shortest root
                if (cur.children[letter - 'a'] == null || cur.word != null){
                    break;
                }
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}

