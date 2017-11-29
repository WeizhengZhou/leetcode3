package gogo;

import gogo.Trie.Node;

import java.util.HashMap;
import java.util.Map;

public class AddSearchWord {
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
    /** Initialize your data structure here. */
    public AddSearchWord() {
        root=new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word==null||word.length()==0) return true;
        return helper(0,word,root);
    }
    
    private boolean helper(int index,String word, Node node) {   	
    	if (index==word.length()) {
    		if (node==null || !node.isEnd) return false;    		
    		return true;
    	}
    	char c=word.charAt(index);
    	if (c!='.') {
    		if (node==null || node.child==null || !node.child.containsKey(c)) return false;
        	return helper(index+1,word,node.child.get(c));
    	} else {
    		if (node==null || node.child==null) return false;
    		for(Node child:node.child.values()){
    			if (helper(index+1,word,child)) return true;
    		}
    		return false;
    	}
    }
    
    
}
