//zz reviewed
package zz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict=new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadderII w=new WordLadderII();
		List<List<String>> res=w.findLadders("hit","cog", dict);
		for(List<String> l:res)
		{
			System.out.println(l.toString());
		}
	}

	 public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		 List<List<String>> res=new LinkedList<List<String>>();
		 if(start==null || end==null || start.length()!=end.length() || start.equals(end)){
			 return res;
		 }
		 Queue<String> current=new LinkedList<String>();
		 Queue<String> next=new LinkedList<String>();
		 Set<String> visited=new HashSet<String>();
		 Map<String,List<String>> map=new HashMap<String,List<String>>();//zz map serves as the visited 
		 current.add(start);
		 visited.add(start);
		 while(!current.isEmpty()){
			 String word=current.poll();
			 for(int i=0;i<word.length();i++){
				 char[] charA=word.toCharArray();
				 for(char c='a';c<='z';c++){					 
					 charA[i]=c;
					 String newWord=new String(charA);
					 //zz organize the logic
					 if((visited.contains(newWord)||newWord.equals(end)) && next.contains(newWord)){
						 List<String> list=map.get(newWord);
						 list.add(word);
						 map.put(newWord, list);
					 }
					 if(!visited.contains(newWord) && (newWord.equals(end)||dict.contains(newWord))){
						 next.add(newWord);
						 visited.add(newWord);
						 List<String> list=new LinkedList<String>();
						 list.add(word);
						 map.put(newWord, list);
					 }
				 }
			 }
			 if(current.isEmpty()){
				 if(next.contains(end)){
					 buildResult(end,start,map,res,new LinkedList<String>());
					 
					 break;
				 }
				 current=new LinkedList<String>(next);
				 next.clear();
			 }
		 }
		 return res;
	 }
	 
	 public void buildResult(String end, String start, Map<String,List<String>> map, List<List<String>> res, LinkedList<String> list){
		 if(end.equals(start)){
			 list.addFirst(end);
			 res.add(new LinkedList<String>(list));
			 list.removeFirst();
			 return;
		 }
		 List<String> back=map.get(end);
		 list.addFirst(end);
		 for(String s:back){
			 buildResult(s,start,map,res,list);
		 }	 
		 list.removeFirst();
	 }
}
