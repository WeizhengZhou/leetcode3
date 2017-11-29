package gogo;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
 * where the two words do not share common letters. 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 * */
public class MaxProductWords {
	public static void main(String[] args) {
		MaxProductWords m= new MaxProductWords();
		System.out.println(m.maxProduct(new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
		System.out.println(m.maxProduct(new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
		System.out.println(m.maxProduct(new String[] {"a", "aa", "aaa", "aaaa"}));
	}
    public int maxProduct(String[] words) {
        if (words==null || words.length<2) return 0;
        Map<String, Integer> map=new HashMap<> ();
        for(int i=0;i<words.length;i++) {
        	String word=words[i];
        	int n=0;
        	for(int j=0;j<word.length();j++) {	
        		char c=word.charAt(j);
        		n=n|1<<(c-'a');
        	}
        	map.put(word,n);
        }
        int max=0;
        for(int i=0;i<words.length;i++) {
        	int n1=map.get(words[i]);
        	for(int j=i+1;j<words.length;j++) {
        		int n2=map.get(words[j]);
        		if ((n1&n2)==0) {
        			max=Math.max(words[i].length()*words[j].length(),max);
        		}
        	}
        }
        return max;
    }
}
