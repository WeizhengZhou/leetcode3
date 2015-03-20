//zz reviewed
package zz;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict=new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadder w=new WordLadder();
		System.out.println(w.ladderLength("hit","cog", dict));

	}
	
	 public int ladderLength(String start, String end, Set<String> dict) {
		 if(start==null || end==null || start.length()!=end.length() || start.equals(end)){
			 return 0;
		 }
		 Queue<String> current=new LinkedList<String>();
		 Queue<String> next=new LinkedList<String>();
		 Set<String> visited=new HashSet<String>();
		 current.add(start);
		 visited.add(start);
		 int level=1;
		 while(!current.isEmpty()){
			 String word=current.poll();
			 /*List<String> neighbor=build(word,end,dict,visited);
			 if(neighbor.contains(end)){
				 return level+1;
			 }
			 next.addAll(neighbor);*/
			 for(int i=0;i<word.length();i++){
				 char[] charA=word.toCharArray();
				 for(char c='a';c<='z';c++){					 
					 charA[i]=c;
					 String newWord=new String(charA);
					 //String newWord=word.substring(0, i)+c+word.substring(i+1);
					 //zz seperate the endWord
					 if(!visited.contains(newWord) && (newWord.equals(end)||dict.contains(newWord))){
						 next.add(newWord);
						 visited.add(newWord);
						 if(newWord.equals(end)){
							 return level+1;
						 }
					 }
				 }
			 }
			 if(current.isEmpty()){
				 current=new LinkedList<String>(next);
				 next.clear();
				 level++;
			 }
		 }
		 return -1;
	 }
	 /*
	  public int ladderLength(String start, String end, Set<String> dict) {
        int level=0;
        if(start == null || end == null || dict == null) return level;
        Queue<String> currLevel = new LinkedList<>();
        Queue<String> nextLevel = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        currLevel.add(start);
        visited.add(start);
        level++;
        while(!currLevel.isEmpty()){
            String word = currLevel.remove();
            for(int i=0;i<word.length();i++){
                char[] wordArr = word.toCharArray();
                for(char c='a';c<='z';c++){
                    wordArr[i] = c;
                    String newWord = new String(wordArr);
                    if(newWord.equals(end)) return level+1;
                    if(visited.contains(newWord) || !dict.contains(newWord)) continue;
                    visited.add(newWord);
                    nextLevel.add(newWord);
                }
            }
            if(currLevel.isEmpty() == true){
                currLevel = new LinkedList<>(nextLevel);
                nextLevel.clear();
                level++;
            }
        }
        return 0;
    }
	  * */
	 
	 public List<String> build(String word, String end, Set<String> dict, Set<String> visited){
		 List<String> res=new LinkedList<String>();
		 for(int i=0;i<word.length();i++){
			 for(char c='a';c<='z';c++){
				 char[] charA=word.toCharArray();
				 charA[i]=c;
				 String newWord=new String(charA);
				 //String newWord=word.substring(0, i)+c+word.substring(i+1);
				 if(!visited.contains(newWord) && (newWord.equals(end)||dict.contains(newWord))){
					 res.add(newWord);
					 visited.add(newWord);
					 if(newWord.equals(end)){
						 return res;
					 }
				 }
			 }
		 }
		 return res;
	 }

}
