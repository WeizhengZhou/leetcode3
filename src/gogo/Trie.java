package gogo;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	class Node {
		char val;
		boolean isEnd;
		Map<Character, Node> child;
		Node(char c){
			val=c;
		}
		Node() {
			
		}
	}
	Node root;
    public Trie() {
        root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if (word==null || word.length()==0) return;
        Node cur=root;
        for(int i=0;i<word.length();i++) {
        	char c= word.charAt(i);
        	Map<Character, Node> child=cur.child==null ? new HashMap<Character, Node> () : cur.child; 
        	if (!child.containsKey(c)) {
        		child.put(c, new Node(c));
        	}
        	cur.child = child;
        	cur=child.get(c);
        }
        cur.isEnd=true;     
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word==null||word.length()==0) return true;
        Node cur=root;
        for (int i=0;i<word.length();i++) {
        	char c=word.charAt(i);
        	if (cur==null || cur.child==null || !cur.child.containsKey(c)) return false;
        	cur=cur.child.get(c);
        }
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix==null||prefix.length()==0) return true;
        Node cur=root;
        for (int i=0;i<prefix.length();i++) {
        	char c=prefix.charAt(i);
        	if (cur==null || cur.child==null || !cur.child.containsKey(c)) return false;
        	cur=cur.child.get(c);
        }
        return true;
    }
}
