//用Trie做 代码自己写的
import java.util.*;

public class Solution {
	String[] dict;
	class TrieNode{
		TrieNode[] child;
		int wordsIdx;
		
		public TrieNode() {
			child = new TrieNode[26];
			wordsIdx = -1;
		}
	}
	
	
	class Trie{
		TrieNode root;
		//关于这里有一个问题：String is passed by “reference” in Java
		//可以参考这里：https://www.programcreek.com/2013/09/string-is-passed-by-reference-in-java/
		String longestWord;
		public Trie() {
			root = new TrieNode();
			longestWord = "";
		}
		
		public void insert(String word, int idx) {
			TrieNode p = root;
			for(char c : word.toCharArray()){
				if(p.child[c - 'a'] == null) {
					p.child[c - 'a'] = new TrieNode();
				}
				p = p.child[c - 'a'];	
			}
			p.wordsIdx = idx;
		}
		
		private void dfsHelper(TrieNode p) {
			if(p.wordsIdx != -1 && dict[p.wordsIdx].length() > longestWord.length()) {
				longestWord = dict[p.wordsIdx];
			}
			for(int i = 0; i < 26; i++) {
				if(p.child[i] != null && p.child[i].wordsIdx != -1) {
					dfsHelper(p.child[i]);
				}
			}
		}
		
		public String getLongestWord() {

			dfsHelper(root);
			return longestWord;
		}
	}
	
	public String longestWord(String[] words) {
		dict = words;
        Trie trie = new Trie();
        
        for(int i = 0; i < words.length; i++) {
        		trie.insert(words[i], i);
        }
        
        return trie.getLongestWord();
    }
	

}
